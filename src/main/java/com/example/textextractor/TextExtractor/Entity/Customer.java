package com.example.textextractor.TextExtractor.Entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "Address")
    private String address;

    @Column(name = "Age")
    private int age;

    @Column(name = "MobileNumber")
    private String mobileNumber;

}
