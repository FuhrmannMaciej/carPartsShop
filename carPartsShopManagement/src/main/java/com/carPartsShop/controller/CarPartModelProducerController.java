package com.carPartsShop.controller;

import com.carPartsShop.service.CarPartModelProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CarPartModelProducerController {

    @Autowired
    CarPartModelProducerService producerService;

    @PostMapping(value = "/producer/sync")
    public String sync()
    {
        producerService.syncCarPartModels();
        return "Message sent Successfully to the topic";
    }
}
