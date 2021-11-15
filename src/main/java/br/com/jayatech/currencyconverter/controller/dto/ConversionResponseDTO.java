package br.com.jayatech.currencyconverter.controller.dto;

import br.com.jayatech.currencyconverter.domain.Conversion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConversionResponseDTO {
    private Long conversionId;
    private Integer userId;
    private String currencyFrom;
    private BigDecimal amountFrom;
    private String currencyTo;
    private BigDecimal amountTo;
    private BigDecimal conversionRate;
    private LocalDateTime dateTime;

    public Long getConversionId() {
        return conversionId;
    }

    public Integer getUserId() {
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

    public ConversionResponseDTO(Long conversionId, Integer userId, String currencyFrom, BigDecimal amountFrom,
                                 String currencyTo, BigDecimal amountTo, BigDecimal conversionRate,
                                 LocalDateTime dateTime) {
        this.conversionId = conversionId;
        this.userId = userId;
        this.currencyFrom = currencyFrom;
        this.amountFrom = amountFrom;
        this.currencyTo = currencyTo;
        this.amountTo = amountTo;
        this.conversionRate = conversionRate;
        this.dateTime = dateTime;
    }

    public static ConversionResponseDTO toResponseDTO(Conversion conversion){
        return new ConversionResponseDTO(conversion.getId(), conversion.getUserId(), conversion.getCurrencyFrom(),
                conversion.getAmountFrom(), conversion.getCurrencyTo(),
                conversion.getAmountFrom().multiply(conversion.getConversionRate()),
                conversion.getConversionRate(), conversion.getDate());
    }
}
