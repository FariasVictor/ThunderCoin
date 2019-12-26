package com.invillia.ThunderCoin.domain.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserResponse {

    private long employeeId;

    private String name;

    private BigDecimal balance;



}
