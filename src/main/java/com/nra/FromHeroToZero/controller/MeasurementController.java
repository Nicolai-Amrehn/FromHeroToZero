package com.nra.FromHeroToZero.controller;

import com.nra.FromHeroToZero.dto.CountryDTO;
import com.nra.FromHeroToZero.dto.MeasurementDTO;
import com.nra.FromHeroToZero.dto.MeasurementInputDTO;
import com.nra.FromHeroToZero.infrastructure.Status;
import com.nra.FromHeroToZero.service.CountryService;
import com.nra.FromHeroToZero.service.MeasurementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nra.FromHeroToZero.infrastructure.Status.PROPOSED;

@Controller
public class MeasurementController {

    MeasurementService measurementService;
    CountryService countryService;

    public MeasurementController(MeasurementService measurementService, CountryService countryService) {
        this.measurementService = measurementService;
        this.countryService = countryService;
    }

    @GetMapping("/measurements")
    public String measurements(Model model) {
        List<MeasurementDTO> measurements = measurementService.getAllMeasurements();
        List<CountryDTO> countries = countryService.getAllCountries();
        model.addAttribute("measurements", measurements);
        model.addAttribute("countries", countries);
        model.addAttribute("measurement", new MeasurementInputDTO(0.0, PROPOSED, 2025, 0L));
        return "measurements";
    }

    @PostMapping("/measurements/add")
    public String addMeasurement(@ModelAttribute("measurement") MeasurementInputDTO measurementInputDTO) {
        measurementService.createMeasurement(measurementInputDTO);
        return "redirect:/measurements";
    }

    @GetMapping("/measurements/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        MeasurementDTO measurement = measurementService.getMeasurementById(id);
        List<CountryDTO> countries = countryService.getAllCountries();
        model.addAttribute("measurement", measurement);
        model.addAttribute("countries", countries);
        return "measurement_edit";
    }

    @PostMapping("/measurements/edit/{id}")
    public String editMeasurement(@PathVariable("id") Long id,
                                  @RequestParam("status") Status status) {
        measurementService.updateMeasurement(id, status);
        return "redirect:/measurements";
    }
}
