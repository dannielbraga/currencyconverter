package br.com.jayatech.currencyconverter.controller.dto;

import br.com.jayatech.currencyconverter.domain.Conversion;

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

    public Integer getUserId() {
        return userId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public BigDecimal getAmountFrom() {
        return amountFrom;
    }

    public Conversion toObject() {
        return new Conversion(userId, currencyFrom, currencyTo, amountFrom);
    }
}
