package com.example.securitysystemcoreservice.Models;

public class Visita {
    private String nombre;

    private String direccion;

    private Integer estatus;

    public Visita() {
    }

    public Visita(String nombre, String direccion, Integer estatus) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estatus = estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }
}
