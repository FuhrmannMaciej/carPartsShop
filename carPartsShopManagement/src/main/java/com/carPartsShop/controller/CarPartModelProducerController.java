package com.carPartsShop.controller;

import com.carPartsShop.service.CarPartModelProducerService;
import com.carPartsShop.web.dto.CarPartModelKafkaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CarPartModelProducerController {

    @Autowired
    CarPartModelProducerService producerService;


    @PostMapping(value = "/producer")
    public String sendMessage(@RequestBody CarPartModelKafkaDto json)
    {
        producerService.send(json);
        return "Message sent Successfully to the topic";
    }
}
