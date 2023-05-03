package com.example.securitysystemcoreservice.Controllers;

import com.example.securitysystemcoreservice.Services.DomicilioService;
import com.example.securitysystemcoreservice.Services.exceptions.DomicilioNotFoundException;
import com.example.securitysystemcoreservice.Models.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomiciliosController {
    private final DomicilioService domicilioService;

    @Autowired
    public DomiciliosController(DomicilioService _domicilioService) {
        this.domicilioService = _domicilioService;
    }

    @GetMapping
    public List<Domicilio> getDomicilios() {
        return this.domicilioService.getDomicilios();
    }

    @GetMapping(path = "{id}")
    public Domicilio getDomicilioById(@PathVariable("id") Long id) {
        try {
            return this.domicilioService.getDomicilioById(id);
        } catch (DomicilioNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Domicilio registerNewDomicilio(@RequestBody Domicilio domicilio) {
        return this.domicilioService.addDomicilio(domicilio);
    }

    @PutMapping(path = "{id}")
    public Domicilio updateDomicilio(@PathVariable("id") Long id, @RequestBody Domicilio domicilio) {
        try {
            return this.domicilioService.updateDomicilio(id, domicilio);
        } catch (DomicilioNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(path = "{id}")
    public void deleteDomicilio(@PathVariable("id") Long id) {
        this.domicilioService.deleteDomicilio(id);
    }
}