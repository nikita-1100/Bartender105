package com.example.bartender105.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CalculationDto {
    private String goodName;
    private GoodType goodType;
    private Integer amount;
    private String unit;
}
