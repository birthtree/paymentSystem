package ru.akkuzin.paymentService.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.akkuzin.paymentService.model.enums.RefundStatus;
import ru.akkuzin.paymentService.model.enums.convertor.RefundStatusConverter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Refund extends BaseEntity{
    private BigDecimal refundAmount;
    private String reason;

    @Convert(converter = RefundStatusConverter.class)
    private RefundStatus status;

    @ManyToOne
    @JoinColumn(name = "PaymentTransaction_id", referencedColumnName = "id")
    private PaymentTransaction paymentTransaction;

}
