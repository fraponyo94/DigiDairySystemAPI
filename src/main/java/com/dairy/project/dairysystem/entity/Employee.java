package com.dairy.project.dairysystem.entity;

import com.dairy.project.dairysystem.Enumerated.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "employeeId",length = 15)
    private String employeeId;

    @Column(name = "name",nullable = false,length = 60)
    @NotNull(message = "name cannot be null")
    @Pattern(regexp = "[a-zA-Z]+",message = "Name cannot contain other characters rather than normal characters")
    private String name;

    @Email(message = "please provide a valid email")
    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber",length = 15,nullable = false)
    @NotNull(message = "phone number cannot be null")
    @Pattern(regexp = "[0|[+254]]+[7]\\d{8}", message = "please provide a valid phone number.")
    private int phoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfEmployment",nullable = false)
    @NotEmpty(message = "Please provide date of employment")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfEmployment;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfDismissal")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfDismissal;

    @Column(name = "password")
    private String password;

    @Column(name = "isEnabled")
    private boolean isEnabled;

    @Column(name = "role", length = 20, columnDefinition = "enum( 'ROLE_ADMIN','ROLE_EMPLOYEE')")
    @Enumerated(value = EnumType.STRING)
    private Role role;


}
