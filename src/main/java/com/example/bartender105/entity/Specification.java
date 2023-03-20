package com.example.bartender105.entity;

import com.example.bartender105.DTO.CalculationDTO;
import com.example.bartender105.DTO.GoodType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(
        name = "specificationToCalculationMapping",
        classes = {
                @ConstructorResult(
                        targetClass = CalculationDTO.class,
                        columns = {
                                @ColumnResult(name = "good_name", type = String.class),
                                @ColumnResult(name = "good_type", type = GoodType.class),
                                @ColumnResult(name = "amount", type = Integer.class),
                                @ColumnResult(name = "unit", type = String.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name = "Specification.getCalculation",
        query = "SELECT\n" +
                "CASE\n" +
                "WHEN is_alcohol = true Then amount*:servings\n" +
                "WHEN is_alcohol = false AND is_device = false Then amount*:servings\n" +
                "ELSE amount\n" +
                "END AS amount,\n" +
                "(CASE\n" +
                "                         WHEN is_alcohol = true Then 'alcoholic'\n" +
                "                         WHEN is_alcohol = false AND is_device = false Then 'nonalcoholic'\n" +
                "                         ELSE 'device'\n" +
                "                        END) AS good_type,\n" +
                "                    unit, good_name from specification\n" +
                "                                             JOIN good ON specification.good_id = good.id\n" +
                "                where cocktail_id = :cocktailId",
        resultSetMapping = "specificationToCalculationMapping"
)
@Table(name = "specification")
//@NamedEntityGraph(name = "Specification.default", attributeNodes = @NamedAttributeNode("goods"))
public class Specification extends BaseEntity{

    @ManyToOne()
    @JsonIgnore
    private Cocktail cocktail;

    @ManyToOne()
    //@BatchSize(size = 20000)
    private Good good;

    @Column(name="amount")
    private Float amount;

    @Column(name="unit")
    private String unit;

    public Cocktail getCocktail() {
        return cocktail;
    }

    public Good getGood() {
        return good;
    }

    public Float getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }
}


