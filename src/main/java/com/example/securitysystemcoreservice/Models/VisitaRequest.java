package com.example.securitysystemcoreservice.Models;

public class VisitaRequest {
    private String nombre;
    private long domicilioId;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDomicilioId() {
        return domicilioId;
    }

    public void setDomicilioId(long domicilioId) {
        this.domicilioId = domicilioId;
    }



    public VisitaRequest(String nombre, long domicilioId) {
        this.nombre = nombre;
        this.domicilioId = domicilioId;
    }
}
