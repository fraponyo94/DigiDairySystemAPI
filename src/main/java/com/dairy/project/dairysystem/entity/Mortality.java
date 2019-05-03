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
public class Mortality {
    private int id;
    private String postMortemreport;
    private String findings;
    private Date date;
    private boolean isPostMortemDone;
}
