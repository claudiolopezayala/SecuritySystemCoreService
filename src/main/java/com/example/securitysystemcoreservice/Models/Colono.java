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

    public Colono(){
    }

    public void setId(Long id) {
        this.id = id;
    }
}
