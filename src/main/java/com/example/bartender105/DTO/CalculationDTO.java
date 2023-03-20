package com.example.bartender105.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CalculationDTO {
    private String goodName;
    private GoodType goodType;
    private Integer amount;
    private String unit;
}
