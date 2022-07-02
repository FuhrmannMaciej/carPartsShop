package com.carPartsShop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarPartToCarModelDto {
    private Long carPartId;
    private Long carModelId;
}
