package br.com.jayatech.currencyconverter.config;

import br.com.jayatech.currencyconverter.controller.dto.ConversionResponseDTO;
import br.com.jayatech.currencyconverter.domain.model.Conversion;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Conversion.class, ConversionResponseDTO.class)
                .<BigDecimal>addMapping(src -> src.getAmountFrom().multiply(src.getConversionRate()),
                        ConversionResponseDTO::setAmountTo);

        return modelMapper;
    }
}
