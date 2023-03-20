package com.example.bartender105.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cocktail")
@JsonIgnoreProperties({"pageable"})
public class Cocktail extends BaseEntity{
    @Column(name = "cocktail_name", length = 100)
    private String cocktailName;

    @Column(length = 1200, name="recipe_text")
    private String recipeText;
    @Column(length = 1200, name = "story")
    private String story;
    @Column(name = "goods_prevalence")
    private Integer goodsPrevalence;

//    @OneToMany(mappedBy = "cocktail_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @BatchSize(size = 20000)
//    List<Specification> specification;


}
