package com.example.securitysystemcoreservice.Controllers;

import com.example.securitysystemcoreservice.Models.Acceso;
import com.example.securitysystemcoreservice.Services.ColonoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.http.HttpRequest;

import java.io.IOException;
import java.net.http.HttpClient;

@RestController
@RequestMapping("/acceso")
public class AccesoController {
    private final HttpClient client;
    private final ObjectMapper mapper;
    private final String VisitaURL = "http://x.x.x.x:3001/acceso";
    private final ColonoService colonoService;

    @Autowired
    public AccesoController(ColonoService _colonoService){
        this.client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).followRedirects(HttpClient.Redirect.ALWAYS).build();
        this.mapper = new ObjectMapper();
        this.colonoService = _colonoService;
    }

    @PostMapping
    public void RegistrarAcceso (Acceso acceso) throws IOException, InterruptedException {

    }
}
