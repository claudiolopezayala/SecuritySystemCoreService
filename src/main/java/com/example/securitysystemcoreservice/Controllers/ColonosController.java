package com.example.securitysystemcoreservice.Controllers;

import com.example.securitysystemcoreservice.Models.Colono;
import com.example.securitysystemcoreservice.Services.ColonoService;
import com.example.securitysystemcoreservice.Services.exceptions.ColonoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/colonos")
public class ColonosController {
    private final ColonoService colonoService;

    @Autowired
    public ColonosController(ColonoService colonoService) {
        this.colonoService = colonoService;
    }

    @GetMapping
    public List<Colono> getColonos() {
        return this.colonoService.getColonos();
    }

    @GetMapping(path = "{id}")
    public Colono getColonoById(@PathVariable("id") Long id) {
        try {
            return this.colonoService.getColonoById(id);
        } catch (ColonoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Colono registerNewColono(@RequestBody Colono colono) {
        return this.colonoService.addColono(colono);
    }

    @PutMapping(path = "{id}")
    public Colono updateColono(@PathVariable("id") Long id, @RequestBody Colono colono) {
        try {
            return this.colonoService.updateColono(id, colono);
        } catch (ColonoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(path = "{id}")
    public void deleteColono(@PathVariable("id") Long id) {
        this.colonoService.deleteColono(id);
    }
}
