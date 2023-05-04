package com.example.securitysystemcoreservice.Models;

public class Acceso {
    private Long id;
    private String nombreColono;
    private Boolean ingreso;
    private String fechaHoraAcceso;
    private String direccion;

    public Acceso() {

    }

    public Acceso(Long id, String nombreColono, Boolean ingreso, String fechaHoraAcceso, String direccion) {
        this.id = id;
        this.nombreColono = nombreColono;
        this.ingreso = ingreso;
        this.fechaHoraAcceso = fechaHoraAcceso;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreColono() {
        return nombreColono;
    }

    public void setNombreColono(String nombreColono) {
        this.nombreColono = nombreColono;
    }

    public Boolean getIngreso() {
        return ingreso;
    }

    public void setIngreso(Boolean ingreso) {
        this.ingreso = ingreso;
    }

    public String getFechaHoraAcceso() {
        return fechaHoraAcceso;
    }

    public void setFechaHoraAcceso(String fechaHoraAcceso) {
        this.fechaHoraAcceso = fechaHoraAcceso;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
