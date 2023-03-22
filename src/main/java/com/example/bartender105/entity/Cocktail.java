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
@NamedEntityGraph(
        name = "cocktail_entity-graph",
        attributeNodes = @NamedAttributeNode(value = "specification", subgraph = "good-subgraph"),
        subgraphs = {
                @NamedSubgraph(
                        name = "good-subgraph",
                        attributeNodes = @NamedAttributeNode(value = "good")
                )
        }
)
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cocktail_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Specification> specification;


}
