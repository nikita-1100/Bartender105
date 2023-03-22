package com.example.bartender105.repository;

import com.example.bartender105.entity.Cocktail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {
    String cocktailsNativeQuery= "SELECT * from cocktail WHERE " +
            "id in ( " +
            "SELECT distinct cocktail_id from specification " +
            "JOIN good on specification.good_id = good.id " +
            "WHERE good_name='Водка')";

    String fuzzySearchQuery = "SELECT * FROM cs(:param)";

    @Override
    @EntityGraph(attributePaths = {"specification.good"})
    Page<Cocktail> findAll(Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {"specification.good"})
    List<Cocktail> findAll();

    @Query(value = cocktailsNativeQuery, nativeQuery = true)
    Page<Cocktail> getCocktailsWith(Pageable pageable);

    @Query(value = fuzzySearchQuery, nativeQuery = true)
    Page<Cocktail> getSearchedCocktails(Pageable pageable, String[] param);

    @Query(nativeQuery = true, value = "SELECT sum(amount*strength)/:altStrength*:servings from specification\n" +
            "JOIN good ON specification.good_id = good.id\n" +
            "WHERE cocktail_id = :cocktailId AND is_alcohol = true")
    Integer getAltVolume(Integer cocktailId, Integer servings, Integer altStrength);
}
