package com.nra.FromHeroToZero.controller;

import com.nra.FromHeroToZero.dto.CountryDTO;
import com.nra.FromHeroToZero.infrastructure.Mapper;
import com.nra.FromHeroToZero.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Controller
public class HomeController {

    private final CountryService countryService;
    private final Mapper mapper;

    @Autowired
    public HomeController(CountryService countryService, Mapper mapper) {
        this.countryService = countryService;
        this.mapper = mapper;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/workspace")
    String workspace(Model model) {
        List<CountryDTO> countries = countryService.getAllCountries()
                .stream()
                .map(mapper::toCountryDTO)
                .collect(toList());
        model.addAttribute("countries", countries);
        return "workspace";
    }
}
