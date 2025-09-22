package com.nra.FromHeroToZero.controller;

import com.nra.FromHeroToZero.dto.CountryDTO;
import com.nra.FromHeroToZero.dto.MeasurementDTO;
import com.nra.FromHeroToZero.service.CountryService;
import com.nra.FromHeroToZero.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final MeasurementService measurementService;
    private final CountryService countryService;

    @Autowired
    public HomeController(MeasurementService measurementService, CountryService countryService) {
        this.measurementService = measurementService;
        this.countryService = countryService;
    }

    @GetMapping("/")
    String home(Model model) {
        List<MeasurementDTO> measurements = measurementService.getMeasurementsInOrder();
        List<CountryDTO> countries = countryService.getAllCountries();
        model.addAttribute("measurements", measurements);
        model.addAttribute("countries", countries);
        return "index";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

}
