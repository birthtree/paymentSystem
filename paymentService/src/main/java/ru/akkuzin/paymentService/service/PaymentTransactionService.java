package ru.akkuzin.paymentService.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ru.akkuzin.paymentService.mapper.PaymentTransactionMapper;
import ru.akkuzin.paymentService.model.dto.CreatePaymentTransactionRequest;
import ru.akkuzin.paymentService.model.dto.CreatePaymentTransactionResponse;
import ru.akkuzin.paymentService.model.entity.PaymentTransaction;
import ru.akkuzin.paymentService.repository.PaymentTransactionRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentTransactionService {
    private final PaymentTransactionRepository paymentTransactionRepository;


    @Transactional
    public PaymentTransaction save(PaymentTransaction paymentTransaction) {
          return paymentTransactionRepository.save(paymentTransaction);
    }
}
