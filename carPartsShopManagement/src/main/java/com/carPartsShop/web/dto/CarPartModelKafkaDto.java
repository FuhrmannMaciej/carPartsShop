package com.carPartsShop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarPartModelKafkaDto {

    private String carModelName;

    private int yearOfProduction;

    private String carPartName;

    private double price;

    private int quantity;
}
