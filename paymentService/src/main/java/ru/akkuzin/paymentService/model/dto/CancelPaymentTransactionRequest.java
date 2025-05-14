package ru.akkuzin.paymentService.model.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelPaymentTransactionRequest {
    @NotNull
    private Long transactionId;
    @NotNull
    @Min(value = 1, message = "Refunded amount must not be null")
    private BigDecimal refaundedAmount;
    private String reasons;
}
