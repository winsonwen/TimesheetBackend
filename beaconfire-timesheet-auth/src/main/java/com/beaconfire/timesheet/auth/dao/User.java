package com.beaconfire.timesheet.auth.dao;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "emergency_contact1_name")
    private String emergency_contact1_name;
    @Column(name = "emergency_contact1_phone")
    private String emergency_contact1_phone;
    @Column(name = "emergency_contact2_name")
    private String emergency_contact2_name;
    @Column(name = "emergency_contact2_phone")
    private String emergency_contact2_phone;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "password")
    private String password;
}
