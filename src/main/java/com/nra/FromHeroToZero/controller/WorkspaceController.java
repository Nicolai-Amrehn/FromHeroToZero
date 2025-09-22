package com.nra.FromHeroToZero.controller;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.dto.CountryDTO;
import com.nra.FromHeroToZero.infrastructure.Mapper;
import com.nra.FromHeroToZero.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class WorkspaceController {

    private final CountryService countryService;
    private final Mapper mapper;

    @Autowired
    public WorkspaceController(CountryService countryService, Mapper mapper) {
        this.countryService = countryService;
        this.mapper = mapper;
    }

    @GetMapping("/workspace")
    String workspace(Model model) {
        List<CountryDTO> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        model.addAttribute("country", new Country());
        return "workspace";
    }
}
