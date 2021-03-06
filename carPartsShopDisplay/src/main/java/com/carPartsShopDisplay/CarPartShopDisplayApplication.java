package com.carPartsShopDisplay;

import com.carPartsShopDisplay.config.AppConstants;
import com.carPartsShopDisplay.entity.CarPartModel;
import com.carPartsShopDisplay.service.CarPartModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class CarPartShopDisplayApplication {

    @Autowired
    private CarPartModelService carPartModelService;

    public static void main(String[] args) {
        SpringApplication.run(CarPartShopDisplayApplication.class, args);
    }

    @KafkaListener(topics = AppConstants.TOPIC, groupId=AppConstants.GROUP_ID)
    public void listen(CarPartModel json) {
        System.out.println("Received info--> : " +json);

        carPartModelService.saveOrUpdateCarPartModel(json);
    }
}
