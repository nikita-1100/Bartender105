package com.example.bartender105.service;

import com.example.bartender105.dto.CalculationDto;
import com.example.bartender105.entity.Cocktail;
import com.example.bartender105.entity.Specification;
import com.example.bartender105.repository.CocktailRepository;
import com.example.bartender105.repository.SpecificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SpecificationService {
    private final SpecificationRepository specificationRepository;
    private final CocktailRepository cocktailRepository;
//    public List<Specification> GetCocktailSpec(Integer cocktailId){
//        Cocktail cocktail = cocktailRepository.getById(cocktailId);
//        return specificationRepository.findByCocktail(cocktail);
//    }

//    public List<CalculationDto> GetCalculation(Integer cocktailId, Integer servings) {
//        return specificationRepository.getCalculation(cocktailId, servings);
//    }
}
