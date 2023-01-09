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

    private String phone;
    private String email;
    private String address;
    private String profile;
    private String password;

    @Column(name = "em1_firstname")
    private float em1Firstname;

    @Column(name = "em1_lastname")
    private float em1Lastname;

    @Column(name = "em1_phone")
    private float em1Phone;

    @Column(name = "em2_firstname")
    private float em2Firstname;

    @Column(name = "em2_lastname")
    private float em2Lastname;

    @Column(name = "em2_phone")
    private float em2Phone;
}