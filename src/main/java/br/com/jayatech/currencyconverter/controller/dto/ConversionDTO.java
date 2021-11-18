package br.com.jayatech.currencyconverter.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ConversionDTO {
    @NotNull(message = "User Id is required")
    private Long userId;

    @NotEmpty(message = "Currency of origin is required")
    private String currencyFrom;

    @NotEmpty(message = "Destination currency is required")
    private String currencyTo;

    @NotNull(message = "Amount of origin is required")
    private BigDecimal amountFrom;

    public Long getUserId() {
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public void setAmountFrom(BigDecimal amountFrom) {
        this.amountFrom = amountFrom;
    }
}
