package com.dairy.project.dairysystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
public class Cow {
    private String cowId;
    private String parentId;
    private String name;
    private String breed;
    private Date birthdate;
    private Date deathDate;
    private double saleAmount;
    private String sex;
    private boolean isPregnant;
    private Date purchaseDate;
    private double purchaseAmount;

}
