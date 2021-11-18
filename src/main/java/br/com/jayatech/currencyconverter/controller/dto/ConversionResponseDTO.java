package br.com.jayatech.currencyconverter.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ConversionResponseDTO {
    private Long id;
    private Long userId;
    private String currencyFrom;
    private BigDecimal amountFrom;
    private String currencyTo;
    private BigDecimal amountTo;
    private BigDecimal conversionRate;
    private LocalDateTime dateTime;
}
