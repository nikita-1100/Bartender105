package com.example.bartender105.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TotalVolumeDTO {
    private Integer cocktailId;
    private Integer services;
    private Integer strength;
    private Integer totalVolume;
}
