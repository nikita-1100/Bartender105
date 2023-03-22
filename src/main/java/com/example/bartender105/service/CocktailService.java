package com.example.bartender105.service;

import com.example.bartender105.dto.TotalVolumeDto;
import com.example.bartender105.entity.Cocktail;
import com.example.bartender105.repository.CocktailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CocktailService {
    private final CocktailRepository cocktailRepository;
    public List<Cocktail> getAll(){
        return cocktailRepository.findAll();
    }
    public Page<Cocktail> getAllPageable(Integer pageNumber,Integer pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return cocktailRepository.findAll(pageable);
    }
    public Cocktail getById(Integer id){
        return cocktailRepository.findById(id).get();
    }
    public Page<Cocktail> getCocktailsWith(Integer pageNumber,Integer pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return cocktailRepository.getCocktailsWith(pageable);
    }

    public Page<Cocktail> getSearchedCocktails(Integer pageNumber,Integer pageSize, String searchTerm){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        String[] s = searchTerm.split(",");
        return cocktailRepository.getSearchedCocktails(pageable,s);
    }

    public TotalVolumeDto getAltVolume(Integer cocktailId, Integer servings, Integer altStrength){
        return new TotalVolumeDto(cocktailId,servings,altStrength,
                cocktailRepository.getAltVolume(cocktailId,servings,altStrength));
    }


    public List<Cocktail> getAllUnpageable() {
        return cocktailRepository.findAll();
    }
}
