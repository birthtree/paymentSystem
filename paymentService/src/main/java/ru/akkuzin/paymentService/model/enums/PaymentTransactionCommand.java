package ru.akkuzin.paymentService.model.enums;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum PaymentTransactionCommand {
    CREATE,
    REFUND,
    UNKNOWN;

    public static PaymentTransactionCommand fromString(String command) {
        try{
            return PaymentTransactionCommand.valueOf(command);
        }
        catch(Exception e){
            log.error(e.getMessage());
            return UNKNOWN;
        }
    }
}
