package com.example.securitysystemcoreservice.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
@Table
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String calle;
    private int numero;

    public Domicilio() {
    }

    public void setId(Long id) {
        this.id = id;
    }
}
