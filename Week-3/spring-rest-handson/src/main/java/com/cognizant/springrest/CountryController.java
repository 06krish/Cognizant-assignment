package com.cognizant.springrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private ApplicationContext context;

    @GetMapping
    public Country getCountryIndia() {
        LOGGER.info("START");
        Country country = context.getBean("country", Country.class);
        LOGGER.info("END");
        return country;
    }

    @GetMapping("/{code}")
    @SuppressWarnings("unchecked")
    public Country getCountryByCode(@org.springframework.web.bind.annotation.PathVariable String code) {
        LOGGER.info("START");
        java.util.List<Country> countries = (java.util.List<Country>) context.getBean("countryList",
                java.util.List.class);
        Country foundCountry = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
        LOGGER.info("END");
        return foundCountry;
    }
}
