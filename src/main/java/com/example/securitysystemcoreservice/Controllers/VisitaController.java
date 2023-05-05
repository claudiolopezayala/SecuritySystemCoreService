package com.example.securitysystemcoreservice.Controllers;

import com.example.securitysystemcoreservice.Models.Visita;
import com.example.securitysystemcoreservice.Models.VisitaRequest;
import com.example.securitysystemcoreservice.Services.VisitaService;
import com.example.securitysystemcoreservice.Services.exceptions.DomicilioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/visita")
public class VisitaController {

    private final VisitaService visitaService;

    @Autowired
    public VisitaController (VisitaService visitaService){
        this.visitaService = visitaService;
    }

    @PostMapping
    public void registrarVisita (@RequestBody VisitaRequest visitaRequest) throws IOException, InterruptedException, DomicilioNotFoundException {
        this.visitaService.registrarVisita(visitaRequest);
    }

}
