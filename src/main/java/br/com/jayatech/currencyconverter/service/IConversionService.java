package br.com.jayatech.currencyconverter.service;

import br.com.jayatech.currencyconverter.controller.dto.ConversionDTO;
import br.com.jayatech.currencyconverter.controller.dto.ConversionResponseDTO;

public interface IConversionService {
    ConversionResponseDTO convert(ConversionDTO conversionDTO);
}
