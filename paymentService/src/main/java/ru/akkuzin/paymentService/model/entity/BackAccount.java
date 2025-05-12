package ru.akkuzin.paymentService.model.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BackAccount extends BaseEntity {

    private String number;
    private BigDecimal balance;
    private Long customerId;
    private String currency;



}
