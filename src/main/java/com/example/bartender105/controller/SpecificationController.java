package com.example.bartender105.controller;

import com.example.bartender105.dto.CalculationDto;
import com.example.bartender105.entity.Specification;
import com.example.bartender105.service.SpecificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/spec")
public class SpecificationController {
    private final SpecificationService specificationService;
//    @GetMapping("{cocktailId}")
//    public List<Specification> cocktailSpecification(@PathVariable Integer cocktailId){
//        return specificationService.GetCocktailSpec(cocktailId);
//    }

//    @GetMapping("{cocktailId}/calculation")
//    public List<CalculationDto> cocktailCalculation(@PathVariable Integer cocktailId,
//                                                    @RequestParam Integer servings){
//        return specificationService.GetCalculation(cocktailId, servings);
//    }
}
