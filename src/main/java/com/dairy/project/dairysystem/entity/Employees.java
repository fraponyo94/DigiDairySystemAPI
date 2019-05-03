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

public class Employees {
    private String employeeId;
    private String name;
    private String email;
    private String role;
    private int phoneNumber;
    private Date dateOfEmployment;
    private Date dateOfDismissal;

}
