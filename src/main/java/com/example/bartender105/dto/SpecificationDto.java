package com.example.bartender105.dto;


import com.example.bartender105.entity.Specification;
import lombok.Data;

@Data
public class SpecificationDto {
    private Integer id;
    private GoodDto good;
    private Float amount;
    private String unit;

    public static SpecificationDto fromSpecification(Specification spec){
        SpecificationDto specDto = new SpecificationDto();
        specDto.setId(spec.getId());
        specDto.setGood(GoodDto.fromGood(spec.getGood()));
        specDto.setAmount(spec.getAmount());
        specDto.setUnit(spec.getUnit());
        return specDto;
    }
}
