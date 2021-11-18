package br.com.jayatech.currencyconverter.service;

import br.com.jayatech.currencyconverter.domain.model.Conversion;

public interface IConversionService {
    Conversion convert(Conversion conversion);
}
