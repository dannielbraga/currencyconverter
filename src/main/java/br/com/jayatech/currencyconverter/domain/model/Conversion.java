package br.com.jayatech.currencyconverter.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "conversion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conversion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "currency_from", nullable = false)
    private String currencyFrom;

    @Column(name = "currency_to", nullable = false)
    private String currencyTo;

    @Column(name = "amount_from", nullable = false)
    private BigDecimal amountFrom;

    @Column(name = "conversion_rate", nullable = false)
    private BigDecimal conversionRate;

    @Column(name = "date", nullable = false)
    private LocalDateTime dateTime;
}
