package com.example.securitysystemcoreservice.Controllers;

import com.example.securitysystemcoreservice.Models.Colono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/colonos")
public class ColonosController {
    private final ColonosService colonosService;

    @Autowired
    public ColonosController(ColonosService colonosService) {
        this.colonosService = colonosService;
    }

    @GetMapping
    public List<Colono> getColonos() {
        return this.colonosService.getColonos();
    }

    @GetMapping(path = "{id}")
    public Colono getColonoById(@PathVariable("id") Long id) {
        try {
            return this.colonosService.getColonoById(id);
        } catch (ColonoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Colono registerNewColono(@RequestBody Colono colono) {
        return this.colonosService.addColono(colono);
    }

    @PutMapping(path = "{id}")
    public Colono updateColono(@PathVariable("id") Long id, @RequestBody Colono colono) {
        try {
            return this.colonosService.updateColono(id, colono);
        } catch (ColonosNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(path = "{id}")
    public void deleteColono(@PathVariable("id") Long id) {
        this.colonosService.deleteColono(id);
    }
}
