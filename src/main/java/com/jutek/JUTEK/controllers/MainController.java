package com.jutek.JUTEK.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    private String mainPage() {
        return "index";
    }
}
