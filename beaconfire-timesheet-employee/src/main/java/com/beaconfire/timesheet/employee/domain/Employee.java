package com.beaconfire.timesheet.employee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="employee")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String picture;
    private String password;

    @Column(name = "emergency_contact1_name")
    private String emergencyContact1Name;

    @Column(name = "emergency_contact1_phone")
    private String emergencyContact1Phone;

    @Column(name = "emergency_contact2_name")
    private String emergencyContact2Name;

    @Column(name = "emergency_contact2_phone")
    private String emergencyContact2Phone;
}