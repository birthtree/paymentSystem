package ru.akkuzin.paymentService.service.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.akkuzin.paymentService.model.dto.CreatePaymentTransactionRequest;
import ru.akkuzin.paymentService.model.entity.BackAccount;
import ru.akkuzin.paymentService.model.entity.PaymentTransaction;
import ru.akkuzin.paymentService.service.handler.BankAccountService;
import ru.akkuzin.paymentService.util.error.PaymentTransactionValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentTransactionValidator {
    private final Validator validator;
    private final BankAccountService bankAccountService;

    public void validateCreateTransactionRequest(CreatePaymentTransactionRequest request) {
        var violations = validator.validate(request);
        List<String> errors = new ArrayList<>(
                violations.stream()
                        .map(ConstraintViolation::getMessage)
                        .toList()
        );
        Optional<BackAccount> sourceBack = Optional.empty();
        if(request.getSourceBankAccountId()!=null){
            var sourceBank = bankAccountService.findById(request.getSourceBankAccountId());
            if(sourceBank==null){
                errors.add("Source bank account not found, account id: " + request.getSourceBankAccountId());
            }
            if(request.getDestinationBankAccountId()!=null){
                var destBank = bankAccountService.findById(request.getDestinationBankAccountId());
                if(destBank.isEmpty()){
                    errors.add("Destination bank account not found, account id: " + request.getDestinationBankAccountId());
                }
            }
            if(request.getDestinationBankAccountId()!=null){
                var destinationBack = bankAccountService.findById(request.getDestinationBankAccountId());
                if(destinationBack.isEmpty()){
                    errors.add("Destination bank account not found, account id: " + request.getDestinationBankAccountId());
                }
            }

        }
        if(request.getAmount()!=null &&sourceBack.isPresent()){
            if(sourceBack.get().getBalance().compareTo(request.getAmount())<0){
                errors.add("Sourcesasda");
            }
        }
        if(!errors.isEmpty()){
            throw new PaymentTransactionValidationException(errors);
        }
    }
}
