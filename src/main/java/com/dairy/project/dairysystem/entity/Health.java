package com.dairy.project.dairysystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "health")
@Data
@NoArgsConstructor
public class Health {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "healthId")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date",insertable = false,updatable = false)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;

    @Column(name="history")
    private String history;

    @Column(name="Symptoms")
    private String symptoms;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "nameOfVeterinaryDoctor")
    private String nameOfveterinaryDoctor;

    @Column(name = "contactOfVeterinaryDoctor")
    @Pattern(regexp = "[0|[+254]]+[7]\\d{8}", message = "please provide a valid phone number.")
    private int contactOfVeterinaryDoctor;

    @Column(name = "costOfTreatment")
    private double costOfTreatment;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "cowId")
    private Cow cowhealth;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "calfId")
    private Calving calfHealth;



}
