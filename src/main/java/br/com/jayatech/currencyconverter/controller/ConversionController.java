package br.com.jayatech.currencyconverter.controller;

import br.com.jayatech.currencyconverter.controller.dto.ConversionDTO;
import br.com.jayatech.currencyconverter.controller.dto.ConversionResponseDTO;
import br.com.jayatech.currencyconverter.service.IConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/conversions/")
public class ConversionController {

    private final IConversionService iConversionService;

    @Autowired
    public ConversionController(IConversionService iConversionService) {
        this.iConversionService = iConversionService;
    }

    @PostMapping
    public ResponseEntity<ConversionResponseDTO> convert(@Valid @RequestBody ConversionDTO conversionDTO) {
        ConversionResponseDTO conversionResponseDTO = this.iConversionService.convert(conversionDTO);
        return new ResponseEntity<>(conversionResponseDTO, HttpStatus.CREATED);
    }
}
