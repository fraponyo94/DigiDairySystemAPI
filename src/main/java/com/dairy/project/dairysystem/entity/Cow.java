package com.dairy.project.dairysystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cow")
@Data
@NoArgsConstructor
public class Cow {
    @Id
    @Column(name = "cowId")
    private String cowId;

    @Column(name = "cowName",nullable = false)
    private String name;

    @Column(name = "breed",nullable = false)
    private String breed;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthdate;

    @Temporal(TemporalType.DATE)
    @Column(name = "deathdate")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date deathDate;

    @Column(name = "saleAmount")
    private double saleAmount;


    @Column(name = "isPregnant")
    private boolean isPregnant;

    @Column(name = "purchaseDate")
    @Temporal(TemporalType.DATE)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date purchaseDate;

    @Column(name = "purchaseAmount")
    private double purchaseAmount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "cowhealth")
    private List<Health> healthList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Mortality mortality;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "cow")
    private List<Milk> milk;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "cow")
    private List<Breeding> breedings;

}
