package com.carPartsShop;

import com.carPartsShop.service.CarPartModelProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CarPartsShopApplication {

	@Autowired
	private CarPartModelProducerService service;

	public static void main(String[] args) {
		SpringApplication.run(CarPartsShopApplication.class, args);
	}

//	@Scheduled(fixedRate = 5000)
//	public void postCarPartModel() {
//		service.send();
//		System.out.println("Posting car part models");
//	}

}
