package ru.akkuzin.paymentService.model.enums;

import lombok.Getter;

@Getter
public enum PaymentTransactionStatus {
    PROCESSING,
    SUCCESS,
    FAILED;

    public static PaymentTransactionStatus fromString(String string) {
        for (PaymentTransactionStatus paymentTransactionStatus : PaymentTransactionStatus.values()) {
            if (paymentTransactionStatus.name().equalsIgnoreCase(string)) {
                return paymentTransactionStatus;
            }
        }
        throw new IllegalArgumentException("Unknown PaymentTransactionStatus: " + string);
    }
}
