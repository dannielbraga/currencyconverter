package br.com.jayatech.currencyconverter.controller;

import br.com.jayatech.currencyconverter.domain.Conversion;
import br.com.jayatech.currencyconverter.service.IConversionService;
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

    public ConversionController(IConversionService iConversionService) {
        this.iConversionService = iConversionService;
    }

    @PostMapping
    public ResponseEntity<Conversion> convert(@Valid @RequestBody ConversionDTO conversionDTO) {
        this.iConversionService.convert(conversionDTO);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
