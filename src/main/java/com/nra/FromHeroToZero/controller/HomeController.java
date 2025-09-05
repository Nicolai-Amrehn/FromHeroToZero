package com.nra.FromHeroToZero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }
}
