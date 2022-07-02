package com.carPartsShop.service;

import com.carPartsShop.config.AppConstants;
import com.carPartsShop.web.dto.CarPartModelKafkaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarPartModelProducerService {

    @Autowired
    private KafkaTemplate<String, CarPartModelKafkaDto> kafkaTemplate;

    public void send(CarPartModelKafkaDto json) {
        System.out.println("Json Serializer for the CarPartModel : {}"+json);
        kafkaTemplate.send(AppConstants.TOPIC, json);
    }
}
