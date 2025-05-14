package ru.akkuzin.paymentService.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CancelPaymentTransactionCommandHandler  implements PaymentTransactionCommandHandler{
    @Override
    public void processPaymentTransaction() {

    }
}
