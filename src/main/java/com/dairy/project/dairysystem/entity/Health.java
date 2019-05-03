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
public class Health {
    private Date date;
    private String history;
    private String symptioms;
    private String diagnosis;
    private String treatment;
    private String remarks;
    private String nameOfveterinaryDoctor;
    private int contactOfVeterinaryDoctor;
    private double costOfTreatment;

}
