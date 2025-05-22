package ru.akkuzin.paymentService.service.handler;

import ru.akkuzin.paymentService.model.entity.PaymentTransaction;

public interface PaymentTransactionCommandHandler {
    void processPaymentTransaction();
    void proccess(String requestId, String message);
}
