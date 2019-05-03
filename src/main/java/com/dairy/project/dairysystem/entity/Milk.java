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
public class Milk {
    private int id;
    private Date date;
    private double firstMilking;
    private double secondMilking;
    private double otherMilking;
    private double total;
    private double unitsSold;
    private double pricePerUnit;

}
