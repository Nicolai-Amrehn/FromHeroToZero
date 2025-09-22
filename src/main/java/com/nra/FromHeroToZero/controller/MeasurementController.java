package com.nra.FromHeroToZero.controller;

import com.nra.FromHeroToZero.domain.Measurement;
import com.nra.FromHeroToZero.dto.MeasurementDTO;
import com.nra.FromHeroToZero.service.MeasurementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MeasurementController {

    MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("/measurements")
    public String measurements(Model model) {
        List<Measurement> measurements = measurementService.getAllMeasurements();
        model.addAttribute("measurements", measurements);
        model.addAttribute("measurement", new Measurement());
        return "measurements";
    }

    @PostMapping("/measurements/add")
    public String addMeasurement(@ModelAttribute("measurement") MeasurementDTO measurementDTO) {
        measurementService.createMeasurement(measurementDTO);
        return "redirect:/measurements";
    }

}
