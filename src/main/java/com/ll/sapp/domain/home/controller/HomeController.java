package com.ll.sapp.domain.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showMain() {
        return "home/main";
    }

    @GetMapping("/information")
    public String showInformation() {
        return "information";
    }
}
