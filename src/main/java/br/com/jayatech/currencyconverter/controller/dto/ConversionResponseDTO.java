package br.com.jayatech.currencyconverter.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConversionResponseDTO {
    private Long id;
    private Long userId;
    private String currencyFrom;
    private BigDecimal amountFrom;
    private String currencyTo;
    private BigDecimal amountTo;
    private BigDecimal conversionRate;
    private LocalDateTime dateTime;

    public Long getConversionId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public BigDecimal getAmountFrom() {
        return amountFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public BigDecimal getAmountTo() {
        return amountTo;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public void setAmountFrom(BigDecimal amountFrom) {
        this.amountFrom = amountFrom;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public void setAmountTo(BigDecimal amountTo) {
        this.amountTo = amountTo;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
