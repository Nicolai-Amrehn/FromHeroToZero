package com.nra.FromHeroToZero.controller;

import com.nra.FromHeroToZero.dto.CountryDTO;
import com.nra.FromHeroToZero.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    String workspace(Model model) {
        List<CountryDTO> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        model.addAttribute("country", new CountryDTO(null, ""));
        return "countries";
    }

    @PostMapping("/countries/add")
    String addCountry(@ModelAttribute("country") CountryDTO countryDTO) {
        countryService.createCountry(countryDTO);
        return "redirect:/countries";
    }

}
