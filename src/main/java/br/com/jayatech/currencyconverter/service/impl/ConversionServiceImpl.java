package br.com.jayatech.currencyconverter.service.impl;

import antlr.StringUtils;
import br.com.jayatech.currencyconverter.controller.dto.ConversionDTO;
import br.com.jayatech.currencyconverter.controller.dto.ConversionResponseDTO;
import br.com.jayatech.currencyconverter.domain.model.Conversion;
import br.com.jayatech.currencyconverter.domain.model.User;
import br.com.jayatech.currencyconverter.domain.repository.ConversionRepository;
import br.com.jayatech.currencyconverter.domain.repository.UserRepository;
import br.com.jayatech.currencyconverter.exception.InvalidUserException;
import br.com.jayatech.currencyconverter.service.IConversionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConversionServiceImpl implements IConversionService {

    private final UserRepository userRepository;
    private final ConversionRepository conversionRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Value("${exchangerates.api.url}")
    private String urlExchangeRatesApi;

    @Value("${exchangerates.api.access_key}")
    private String accessKeyApi;

    private static final String ACCESS_KEY = "access_key";
    private static final String SYMBOLS = "symbols";
    private static final String FORMAT = "format";

    @Autowired
    public ConversionServiceImpl(UserRepository userRepository, ConversionRepository conversionRepository,
                                 ModelMapper modelMapper, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.conversionRepository = conversionRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public ConversionResponseDTO convert(ConversionDTO conversionDTO) {
        Long userId = conversionDTO.getUserId();
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new InvalidUserException("User not found for Id: " + userId));


        Conversion conversion = toConversion(conversionDTO);

        return toConversionResponseDTO(conversion);
    }

    private void runConversion(ConversionDTO conversionDTO) {
        var url = urlExchangeRatesApi + ACCESS_KEY + "=" + accessKeyApi + "&" + SYMBOLS +
                "=" + getCurrencySymbols(conversionDTO) + "&" + FORMAT + "=1";

        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    private ConversionResponseDTO toConversionResponseDTO(Conversion conversion) {
        return modelMapper.map(conversion, ConversionResponseDTO.class);
    }

    private Conversion toConversion(ConversionDTO conversionDTO) {
        return modelMapper.map(conversionDTO, Conversion.class);
    }

    private String getCurrencySymbols(ConversionDTO conversionDTO) {
        return conversionDTO.getCurrencyFrom() + "," + conversionDTO.getCurrencyTo();
    }
}
