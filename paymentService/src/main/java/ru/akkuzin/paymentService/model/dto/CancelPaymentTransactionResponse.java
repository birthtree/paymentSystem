package ru.akkuzin.paymentService.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.akkuzin.paymentService.model.dto.enums.CommandResultStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelPaymentTransactionResponse {
    private Long refaundId;
    private CommandResultStatus status;
    private String errorMessage;
}
