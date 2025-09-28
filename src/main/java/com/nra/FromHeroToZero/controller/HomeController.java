package com.nra.FromHeroToZero.controller;

import com.nra.FromHeroToZero.dto.MeasurementDTO;
import com.nra.FromHeroToZero.service.MeasurementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final MeasurementService measurementService;

    public HomeController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("/")
    String home(Model model) {
        List<MeasurementDTO> measurements = measurementService.getMeasurementsInOrder();
        model.addAttribute("measurements", measurements);
        return "index";
    }

    @GetMapping("/workspace")
    String workspace() {
        return "workspace";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }
}
