package br.com.jayatech.currencyconverter.service.impl;

import br.com.jayatech.currencyconverter.domain.Conversion;
import br.com.jayatech.currencyconverter.service.IConversionService;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements IConversionService {

    @Override
    public Conversion convert(Conversion conversion) {
        return conversion;
    }
}
