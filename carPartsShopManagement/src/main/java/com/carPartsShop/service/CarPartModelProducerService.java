package com.carPartsShop.service;

import com.carPartsShop.config.AppConstants;
import com.carPartsShop.entity.CarModel;
import com.carPartsShop.entity.CarPart;
import com.carPartsShop.repository.CarModelRepository;
import com.carPartsShop.repository.CarPartRepository;
import com.carPartsShop.web.dto.CarPartModelKafkaDto;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarPartModelProducerService {

    @Autowired
    private KafkaTemplate<String, CarPartModelKafkaDto> kafkaTemplate;

    @Autowired
    private CarModelRepository carModelRepository;

    @Autowired
    private CarPartRepository carPartRepository;

    public void send() {
        CarPartModelKafkaDto json = new CarPartModelKafkaDto();
        List<CarModel> carModels = carModelRepository.findAll();

        for (CarModel carModel : carModels) {
            List<CarPart> carParts = carModel.getCarParts().stream().toList();
            for (CarPart carPart : carParts) {
                json.setCarModelName(carModel.getName());
                json.setYearOfProduction(carModel.getYearOfProduction());
                json.setCarPartName(carPart.getName());
                json.setPrice(carPart.getPrice());
                json.setQuantity(carPart.getQuantity());

                kafkaTemplate.send(AppConstants.TOPIC, json);
            }
        }
    }
}
