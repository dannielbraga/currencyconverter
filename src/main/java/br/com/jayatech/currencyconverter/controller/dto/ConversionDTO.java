package br.com.jayatech.currencyconverter.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ConversionDTO {
    @NotNull(message = "User Id is required")
    private Long userId;

    @NotEmpty(message = "Currency of origin is required")
    private String currencyFrom;

    @NotEmpty(message = "Destination currency is required")
    private String currencyTo;

    @NotNull(message = "Amount of origin is required")
    private BigDecimal amountFrom;
}
