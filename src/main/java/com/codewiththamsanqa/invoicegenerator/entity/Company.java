package com.codewiththamsanqa.invoicegenerator.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "companies")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String name;

    @Column(name = "company_email", nullable = false)
    private String email;

    @Column(name = "_phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "VAT", nullable = false)
    private String vatNumber; // Optional, for tax invoices
}