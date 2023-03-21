package com.example.bartender105.dto;

import com.example.bartender105.entity.Good;
import lombok.Data;

@Data
public class GoodDto {
    private Integer id;
    private String goodName;
    private String recipeText;
    private GoodType type;
    private short strength;
    private Integer prevalence;

    public static GoodDto fromGood(Good good){
        GoodDto goodDto = new GoodDto();
        goodDto.setId(good.getId());
        goodDto.setGoodName(good.getGoodName());
        goodDto.setRecipeText(good.getRecipeText());
        goodDto.setStrength(good.getStrength());
        goodDto.setPrevalence(good.getPrevalence());
        goodDto.setType(getTypeByGood(good));
        return goodDto;
    }

    private static GoodType getTypeByGood(Good good) {
        if (good.getIsAlcohol())
            return GoodType.alcoholic;
        else if (good.getIsDevice())
            return GoodType.device;
        return GoodType.nonalcoholic;
    }

}
