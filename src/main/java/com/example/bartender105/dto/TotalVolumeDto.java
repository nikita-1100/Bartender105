package com.example.bartender105.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TotalVolumeDto {
    private Integer cocktailId;
    private Integer services;
    private Integer strength;
    private Integer totalVolume;
}
