package com.example.securitysystemcoreservice.Models;

import jakarta.persistence.*;


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

    public Domicilio(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }

    public Domicilio(Long id, String calle, int numero) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
