package ru.akkuzin.paymentService.model.enums;

public enum RefundStatus {
    COMPLETED,
    FAILED;

    public static RefundStatus fromString(String string) {
        for (RefundStatus refundStatus : RefundStatus.values()) {
            if (refundStatus.toString().equalsIgnoreCase(string)) {
                return refundStatus;
            }
        }
        throw new IllegalArgumentException("Unknown RefundStatus: " + string);
    }
}
