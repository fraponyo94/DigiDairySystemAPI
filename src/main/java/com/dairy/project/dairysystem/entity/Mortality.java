package com.dairy.project.dairysystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mortality")
@Data
@NoArgsConstructor
public class Mortality {
    @Id
    @Column(name = "cowId",nullable = false)
    private String cowid;

    @Column(name = "postMortemReport")
    private String postMortemreport;

    @Column(name = "findings")
    private String findings;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;

    @Column(name = "isPostMortemDone")
    private boolean isPostMortemDone;

    @MapsId
    @OneToOne(targetEntity = Cow.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "cowId")
    private Cow cowId;
}
