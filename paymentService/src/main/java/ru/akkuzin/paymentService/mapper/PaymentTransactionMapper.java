package ru.akkuzin.paymentService.mapper;

import org.mapstruct.Mapper;
import ru.akkuzin.paymentService.model.dto.CreatePaymentTransactionRequest;
import ru.akkuzin.paymentService.model.dto.CreatePaymentTransactionResponse;
import ru.akkuzin.paymentService.model.entity.PaymentTransaction;

@Mapper
public interface PaymentTransactionMapper {
    PaymentTransaction toEntity(CreatePaymentTransactionRequest request);
    CreatePaymentTransactionResponse toResponse(PaymentTransaction paymentTransaction);
}
