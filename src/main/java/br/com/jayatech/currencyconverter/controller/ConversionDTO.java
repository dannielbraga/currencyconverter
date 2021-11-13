package br.com.jayatech.currencyconverter.controller;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ConversionDTO {
    @NotNull(message = "User Id is required")
    private Integer userId;

    @NotNull(message = "Currency of origin is required")
    private String currencyFrom;

    @NotNull(message = "Destination currency is required")
    private String currencyTo;

    @NotNull(message = "Amount of origin is required")
    private BigDecimal amountFrom;
}
