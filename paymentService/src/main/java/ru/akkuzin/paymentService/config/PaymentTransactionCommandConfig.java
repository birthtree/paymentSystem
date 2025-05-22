package ru.akkuzin.paymentService.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.akkuzin.paymentService.model.enums.PaymentTransactionCommand;
import ru.akkuzin.paymentService.service.handler.CancelPaymentTransactionCommandHandler;
import ru.akkuzin.paymentService.service.handler.CreatePaymentTransactionCommandHandler;
import ru.akkuzin.paymentService.service.handler.PaymentTransactionCommandHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaymentTransactionCommandConfig {
    @Bean
    public Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers(CreatePaymentTransactionCommandHandler createPaymentTransactionCommandHandler, CancelPaymentTransactionCommandHandler cancelPaymentTransactionCommandHandler) {
        Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers = new HashMap<>();
        commandHandlers.put(PaymentTransactionCommand.CREATE, createPaymentTransactionCommandHandler);
        commandHandlers.put(PaymentTransactionCommand.REFUND, cancelPaymentTransactionCommandHandler);
        return commandHandlers;
    }
}
