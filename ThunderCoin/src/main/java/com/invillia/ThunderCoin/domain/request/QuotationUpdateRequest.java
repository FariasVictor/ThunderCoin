package com.invillia.ThunderCoin.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuotationUpdateRequest {

    @NotNull( message = "Valor não pode ser nulo!")
    @Positive(message = "Valor deve ser maior que zero!")
    private BigDecimal value;
}
