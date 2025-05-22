package ru.akkuzin.paymentService.service.handler;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akkuzin.paymentService.controller.kafka.producer.PaymentTransactionProducer;
import ru.akkuzin.paymentService.mapper.PaymentTransactionMapper;
import ru.akkuzin.paymentService.model.dto.CreatePaymentTransactionRequest;
import ru.akkuzin.paymentService.model.entity.BackAccount;
import ru.akkuzin.paymentService.model.enums.PaymentTransactionCommand;
import ru.akkuzin.paymentService.model.enums.PaymentTransactionStatus;
import ru.akkuzin.paymentService.service.PaymentTransactionService;
import ru.akkuzin.paymentService.service.validator.PaymentTransactionValidator;
import ru.akkuzin.paymentService.util.JsonConverter;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreatePaymentTransactionCommandHandler implements PaymentTransactionCommandHandler{

    private final JsonConverter jsonConverter;
    private final PaymentTransactionValidator paymentTransactionValidator;
    private final BankAccountService bankAccountService;
    private final PaymentTransactionMapper paymentTransactionMapper;
    private final PaymentTransactionService paymentTransactionService;
    private final PaymentTransactionProducer paymentTransactionProducer;
    @Override
    public void processPaymentTransaction() {

    }

    @Override
    @Transactional
    public void proccess(String requestId, String message) {
        var request = jsonConverter.toObject(message, CreatePaymentTransactionRequest.class);
        paymentTransactionValidator.validateCreateTransactionRequest(request);
        var sourceBankAccount = bankAccountService.findById(request.getSourceBankAccountId()).get();
        sourceBankAccount.setBalance(
                sourceBankAccount.getBalance().subtract(request.getAmount())
        );
        Optional<BackAccount> destinationBankAccount = Optional.empty();
        if(request.getDestinationBankAccountId() != null) {
            var destBankAccount = bankAccountService.findById(request.getDestinationBankAccountId()).get();
            destBankAccount.setBalance(
                    destBankAccount.getBalance().add(request.getAmount())
            );
        }
        var entity = paymentTransactionMapper.toEntity(request);
        entity.setSourceBackAccount(sourceBankAccount);
        destinationBankAccount.ifPresent(entity::setDestinationBackAccount);
        entity.setPaymentTransactionStatus(PaymentTransactionStatus.SUCCESS);
        var savedEnity = paymentTransactionService.save(entity);
        paymentTransactionProducer.sendCommandResult(
                PaymentTransactionProducer.RESULT_TOPIC,
                requestId,
                jsonConverter.toJson(savedEnity),
                PaymentTransactionCommand.CREATE.name()
        );
    }

}
