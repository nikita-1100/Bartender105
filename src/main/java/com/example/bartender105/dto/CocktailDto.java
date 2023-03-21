package com.example.bartender105.dto;


import com.example.bartender105.entity.Cocktail;
import lombok.Data;

import java.util.List;

@Data
public class CocktailDto {
    private Integer id;
    private String cocktailName;
    private String recipeText;
    private String story;
    private Integer goodsPrevalence;
    private List<SpecificationDto> specifications;

    public static CocktailDto fromCocktail(Cocktail cocktail){
        CocktailDto cocktailDto = new CocktailDto();
        cocktailDto.setId(cocktail.getId());
        cocktailDto.setCocktailName(cocktail.getCocktailName());
        cocktailDto.setRecipeText(cocktail.getRecipeText());
        cocktailDto.setStory(cocktail.getStory());
        cocktailDto.setGoodsPrevalence(cocktail.getGoodsPrevalence());
        //TODO: cocktailDto.setSpecifications;
        return cocktailDto;

    };
}
