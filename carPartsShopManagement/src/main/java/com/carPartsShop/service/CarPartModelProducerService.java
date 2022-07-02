package com.carPartsShop.service;

import com.carPartsShop.config.AppConstants;
import com.carPartsShop.entity.CarModel;
import com.carPartsShop.entity.CarPart;
import com.carPartsShop.repository.CarModelRepository;
import com.carPartsShop.kafka.dto.CarPartModelKafkaDto;
import com.carPartsShop.repository.CarPartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class CarPartModelProducerService {

    @Autowired
    private KafkaTemplate<String, CarPartModelKafkaDto> kafkaTemplate;

    @Autowired
    private CarPartRepository carPartRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    public void syncCarPartModels() {
        int counter = 0;
        List<CarModel> carModels = carModelRepository.findAll();

        for (CarModel carModel : carModels) {
            List<CarPart> carParts = carModel.getCarParts().stream().toList();
            for (CarPart carPart : carParts) {
                CarPartModelKafkaDto json = createCarPartModelKafkaDto(carModel, carPart);
                counter++;
                kafkaTemplate.send(AppConstants.TOPIC, json);
            }
        }
        log.info("Sent {} car part models to Kafka", counter);
    }

    private CarPartModelKafkaDto createCarPartModelKafkaDto(CarModel carModel, CarPart carPart) {
        CarPartModelKafkaDto json = new CarPartModelKafkaDto();
        json.setCarModelSourceSystemId(carModel.getId());
        json.setCarPartSourceSystemId(carPart.getId());
        json.setCarModelName(carModel.getName());
        json.setYearOfProduction(carModel.getYearOfProduction());
        json.setCarPartName(carPart.getName());
        json.setPrice(carPart.getPrice());
        json.setQuantity(carPart.getQuantity());
        return json;
    }

    public void sendCarPartModelUpdate(Long carModelId, Long carPartId) {
        CarModel carModel = carModelRepository.findById(carModelId).orElseThrow();
        CarPart carPart = carPartRepository.findById(carPartId).orElseThrow();

        CarPartModelKafkaDto json = createCarPartModelKafkaDto(carModel, carPart);

        kafkaTemplate.send(AppConstants.TOPIC, json);
    }
}
