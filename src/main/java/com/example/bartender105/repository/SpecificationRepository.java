package com.example.bartender105.repository;

import com.example.bartender105.dto.CalculationDto;
import com.example.bartender105.entity.Cocktail;
import com.example.bartender105.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification,Integer> {

//    @Query(nativeQuery = true)
//    List<CalculationDto> getCalculation(Integer cocktailId, Integer servings);


}
