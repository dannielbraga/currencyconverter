package br.com.jayatech.currencyconverter.controller;

import br.com.jayatech.currencyconverter.controller.dto.ConversionDTO;
import br.com.jayatech.currencyconverter.controller.dto.ConversionResponseDTO;
import br.com.jayatech.currencyconverter.domain.model.Conversion;
import br.com.jayatech.currencyconverter.service.IConversionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/conversions")
public class ConversionController {

    private final IConversionService iConversionService;
    private final ModelMapper modelMapper;

    @Autowired
    public ConversionController(IConversionService iConversionService, ModelMapper modelMapper) {
        this.iConversionService = iConversionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<ConversionResponseDTO> convert(@Valid @RequestBody ConversionDTO conversionDTO) {
        Conversion conversion = this.iConversionService.convert(toConversion(conversionDTO));
        return new ResponseEntity<>(toConversionResponseDTO(conversion), HttpStatus.OK);
    }

    private ConversionResponseDTO toConversionResponseDTO(Conversion conversion) {
        return modelMapper.map(conversion, ConversionResponseDTO.class);
    }

    private Conversion toConversion(ConversionDTO conversionDTO) {
        return modelMapper.map(conversionDTO, Conversion.class);
    }
}
