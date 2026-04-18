package com.moosa.interviewlog.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;
    private String status;
    private String notes;
}