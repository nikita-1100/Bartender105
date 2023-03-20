package com.example.bartender105.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "good")
public class Good extends BaseEntity{

    @Column(name = "link")
    private String link;

    @Column(name="good_name")
    private String goodName;

    @Column(name = "recipe_text", length = 1200)
    private String recipeText;

    @Column(name = "type")
    private String type;

    @Column(name = "strength")
    private short strength;

    @Column(name = "is_device")
    private Boolean isDevice;

    @Column(name = "is_alcohol")
    private Boolean isAlcohol;

    @Column(name = "prevalence")
    private Integer prevalence;
}
