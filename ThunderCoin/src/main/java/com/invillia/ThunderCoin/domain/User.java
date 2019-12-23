package com.invillia.ThunderCoin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class User {

    private long id;
    private long employeeId;
    private String name;
    private BigDecimal balance;
    private LocalDate createdAt;
    private LocalDate updatedAt;


}
