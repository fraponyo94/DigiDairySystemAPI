package com.dairy.project.dairysystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
public class Expenses {
    private int id;
    private String itemName;
    private double quantity;
    private double pricePerUnit;
    private String remarks;
    private String date;
}
