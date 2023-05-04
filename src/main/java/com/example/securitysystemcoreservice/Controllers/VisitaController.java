package com.example.securitysystemcoreservice.Controllers;

import com.example.securitysystemcoreservice.Models.Visita;
import com.example.securitysystemcoreservice.Services.DomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Duration;
import java.net.http.HttpRequest.BodyPublishers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpRequest;

import java.io.IOException;
import java.net.http.HttpClient;

@RestController
@RequestMapping("/visita")
public class VisitaController {
    private  final HttpClient client;
    private final ObjectMapper mapper;
    private static final String VisitaURL = "http://172.18.70.105:3001/visitas";
    private final DomicilioService domicilioService;
    @Autowired
    public  VisitaController(DomicilioService _domicilioService){
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        this.mapper = new ObjectMapper();

        this.domicilioService = _domicilioService;
    }

    @PostMapping
    public void RegistrarVisita (Visita visita) throws IOException, InterruptedException {
        String jsonRequestBody = this.mapper.writeValueAsString(visita);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VisitaController.VisitaURL))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonRequestBody))
                .build();
    }
}
