package com.example.bartender105.dto;


import com.example.bartender105.entity.Cocktail;
import com.example.bartender105.entity.Specification;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

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
        cocktailDto.setSpecifications(fromSpec(cocktail.getSpecification()));
        return cocktailDto;
    };

    private static List<SpecificationDto> fromSpec(List<Specification> spec){
//        List<SpecificationDto> specDto = new ArrayList<>();
//        for (Specification s: spec){
//            specDto.add(SpecificationDto.fromSpecification(s));
//        }
//        return specDto;
        return spec.stream().map(SpecificationDto::fromSpecification).collect(Collectors.toList());
    }
}
