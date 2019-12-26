package com.invillia.ThunderCoin.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuotationResponse {

    private Long id;

    private BigDecimal value;

    private LocalDateTime createdAt;

    private boolean active;
}