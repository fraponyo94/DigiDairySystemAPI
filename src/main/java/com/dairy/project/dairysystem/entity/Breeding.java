package com.dairy.project.dairysystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
public class Breeding {
    private int id;
    private String noOfCalves;

}
