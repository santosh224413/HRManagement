package com.sanu.hrmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private long id;
    @Column(name="Employee Name", nullable = false, updatable = true)
    private String name;
    @Column(name="Email")
    private String email;
    @Column(name="Job Title")
    private String jobTitle;
    @Column(name="Phone Number")
    private String phoneNumber;
    @Column(name="Image URL")
    private String imageURL;
    @Column(name="Employee Code", nullable = false, updatable = false)
    private String employeeCode;

}
