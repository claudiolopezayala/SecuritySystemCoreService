package com.example.securitysystemcoreservice.Services;

import com.example.securitysystemcoreservice.Models.Domicilio;
import com.example.securitysystemcoreservice.Models.Visita;
import com.example.securitysystemcoreservice.Models.VisitaRequest;
import com.example.securitysystemcoreservice.Services.exceptions.DomicilioNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class VisitaService {
    private  final HttpClient client;
    private final ObjectMapper mapper;
    private static final String VisitaURL = "http://172.18.70.105:3001/visitas";
    private final DomicilioService domicilioService;
    @Autowired
    public  VisitaService(DomicilioService _domicilioService){
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        this.mapper = new ObjectMapper();

        this.domicilioService = _domicilioService;
    }

    public void registrarVisita (VisitaRequest visitaRequest) throws IOException, InterruptedException, DomicilioNotFoundException {
        Visita visita = new Visita();

        visita.setNombre(visitaRequest.getNombre());

        Domicilio domicilio = domicilioService.getDomicilioById(visitaRequest.getDomicilioId());
        String calle = domicilio.getCalle();
        String numero = " #".concat(String.valueOf(domicilio.getNumero()));
        visita.setDireccion(calle.concat(numero));

        visita.setEstatus(0);

        String jsonRequestBody = this.mapper.writeValueAsString(visita);

//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(VisitaService.VisitaURL))
//                .timeout(Duration.ofMinutes(1))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(jsonRequestBody))
//                .build();
//
//        this.client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
