package com.carPartsShop.entity;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "car_part_model")
public class CarPartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_part_source_system_id")
    private Long carPartSourceSystemId;

    @Column(name = "car_model_source_system_id")
    private Long carModelSourceSystemId;

    @Column(name = "car_model_name")
    private String carModelName;

    @Column(name = "year_of_production")
    private int yearOfProduction;

    @Column(name = "car_part_name")
    private String carPartName;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;
}
