package com.hibernate.hibernateFilter;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee extends AbstractEntity {

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50)
    private String emailAddress;

    @Column(length = 12)
    private String mobileNumber;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Designation designation;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public enum Designation {
        SOFTWARE_ENGINEER, SR_SOFTWARE_ENGINEER
    }
}