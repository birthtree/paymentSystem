package ru.akkuzin.paymentService.model.enums.convertor;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.akkuzin.paymentService.model.enums.PaymentTransactionStatus;
import ru.akkuzin.paymentService.model.enums.RefundStatus;

@Converter(autoApply = true)
public class RefundStatusConverter implements AttributeConverter<RefundStatus, String> {
    @Override
    public String convertToDatabaseColumn(RefundStatus refundStatus) {
        return refundStatus == null? null: refundStatus.name();
    }

    @Override
    public RefundStatus convertToEntityAttribute(String s) {
        return s == null ? null : RefundStatus.fromString(s);
    }
}