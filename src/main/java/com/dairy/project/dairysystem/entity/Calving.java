package com.dairy.project.dairysystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Calving {

    @Column(name = "breedingId")
    @Id
    private int id;

    @Column(name = "calfId")
    private  String calveId;

    @Column(name = "dateofCalving")
    @Temporal(TemporalType.DATE)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfCalving;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthweight")
    private double birthWeight;

    @Temporal(TemporalType.DATE)
    @Column(name = "deathdate")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date deathDate;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "calfHealth")
    private List<Health> healthList;

    @MapsId
    @OneToOne(targetEntity = Cow.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "breedingId")
    private Breeding breeding;





}
