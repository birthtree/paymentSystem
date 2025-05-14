package ru.akkuzin.paymentService.controller.kafka.consumer;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.akkuzin.paymentService.model.enums.PaymentTransactionCommand;
import ru.akkuzin.paymentService.service.handler.PaymentTransactionCommandHandler;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentTransactionCommandListener {
    private final Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers;
    @KafkaListener(topics = "payment-command", containerFactory = "kafkaListenerContainerFactory")
    public void consumePaymentTransactionCommand(ConsumerRecord<String, String> record) {
        var command = PaymentTransactionCommand.valueOf(record.value());

    }
    private PaymentTransactionCommand getPaymentTransactionCommand(ConsumerRecord<String, String> record) {
        var commandHeader = record.headers().lastHeader("command");
        if (commandHeader != null) {
            return PaymentTransactionCommand.fromString(new String(commandHeader.value()));
        }
        return PaymentTransactionCommand.UNKNOWN;
    }
}
