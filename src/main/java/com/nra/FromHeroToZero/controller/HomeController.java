package com.nra.FromHeroToZero.controller;

import com.nra.FromHeroToZero.dto.MeasurementDTO;
import com.nra.FromHeroToZero.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final MeasurementService measurementService;

    @Autowired
    public HomeController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("/")
    String home(Model model) {
        List<MeasurementDTO> measurements = measurementService.getTopTenMeasurements();
        model.addAttribute("measurements", measurements);
        return "index";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

}
