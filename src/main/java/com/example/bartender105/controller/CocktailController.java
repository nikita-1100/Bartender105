package com.example.bartender105.controller;

import com.example.bartender105.DTO.TotalVolumeDTO;
import com.example.bartender105.entity.Cocktail;
import com.example.bartender105.service.CocktailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CocktailController {
    private final CocktailService cocktailService;

    @GetMapping("/hi")
    public String hi(){
        return "hi, alcoholic";
    }

    @GetMapping("/cocktails")
    public Page<Cocktail> getAllCocktails(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        return cocktailService.getAllPageable(pageNumber, pageSize);
    }


    @GetMapping("/cocktailsWith")
    public Page<Cocktail> getCocktailsWith(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        return cocktailService.getCocktailsWith(pageNumber, pageSize);
    }

    @GetMapping("/fuzzySearch")
    public Page<Cocktail> getSearchedCocktails(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestBody String searchTerm
    ) {
        return cocktailService.getSearchedCocktails(pageNumber, pageSize, searchTerm);
    }

    @GetMapping("/cocktail/{id}")
    public Cocktail getById(@PathVariable Integer id) {
        return cocktailService.getById(id);
    }

    @GetMapping("/cocktail/{id}/altVolume")
    public TotalVolumeDTO getAltVolume(@PathVariable Integer id,
                                       @RequestParam(value = "servings", required = false, defaultValue = "1") Integer servings,
                                       @RequestParam(value = "altStrength", required = false, defaultValue = "40") Integer altStrength)
    {
        return cocktailService.getAltVolume(id,servings,altStrength);
    }
}
