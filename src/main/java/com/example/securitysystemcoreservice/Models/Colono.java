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
    private Domicilio domicilio;

    public Colono(String nombre, LocalDate fechaHoraRegistro, Domicilio domicilio) {
        this.nombre = nombre;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.domicilio = domicilio;
    }

    public Colono(Long id, String nombre, LocalDate fechaHoraRegistro, Colono colono) {
        this.id = id;
        this.nombre = nombre;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.domicilio = domicilio;
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
