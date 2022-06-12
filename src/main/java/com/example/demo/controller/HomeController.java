package com.example.demo.controller;

import com.example.demo.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CarModelService carModelService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("car_models", carModelService.getAllCarModels());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
