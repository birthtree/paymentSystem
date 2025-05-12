package ru.akkuzin.paymentService.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.akkuzin.paymentService.model.enums.PaymentTransactionStatus;
import ru.akkuzin.paymentService.model.enums.convertor.PaymentTransactionStatusConvertor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransaction extends BaseEntity {
    private BigDecimal amount;
    private String currency;
    private String errorMessage;

    @ManyToOne
    @JoinColumn(name ="sourceBackAccountId")
    private BackAccount sourceBackAccount;

    @ManyToOne
    @JoinColumn(name ="destinationBackAccountId")
    private BackAccount destinationBackAccount;


    @OneToMany(mappedBy = "paymentTransaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Refund> refunds;

    @Convert(converter = PaymentTransactionStatusConvertor.class)
    private PaymentTransactionStatus paymentTransactionStatus;
}
