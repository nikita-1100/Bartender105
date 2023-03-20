package com.example.bartender105.controller;

import com.example.bartender105.DTO.CalculationDTO;
import com.example.bartender105.entity.Specification;
import com.example.bartender105.service.SpecificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpecificationController {
    private final SpecificationService specificationService;
    @GetMapping("/cocktail/{cocktailId}/spec")
    public List<Specification> cocktailSpecification(@PathVariable Integer cocktailId){
        return specificationService.GetCocktailSpec(cocktailId);
    }

    @GetMapping("/cocktail/{cocktailId}/calculation")
    public List<CalculationDTO> cocktailCalculation(@PathVariable Integer cocktailId,
                                                    @RequestParam Integer servings){
        return specificationService.GetCalculation(cocktailId, servings);
    }
}
