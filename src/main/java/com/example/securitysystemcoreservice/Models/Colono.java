package com.example.securitysystemcoreservice.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table
public class Colono {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private LocalDate fechaHoraRegistro;
    @ManyToOne
    private Colono colono;

    public Colono(String nombre, LocalDate fechaHoraRegistro, Colono colono) {
        this.nombre = nombre;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.colono = colono;
    }

    public Colono(Long id, String nombre, LocalDate fechaHoraRegistro, Colono colono) {
        this.id = id;
        this.nombre = nombre;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.colono = colono;
    }

    public Colono(){
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(LocalDate fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Colono getColono() {
        return colono;
    }

    public void setColono(Colono colono) {
        this.colono = colono;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
