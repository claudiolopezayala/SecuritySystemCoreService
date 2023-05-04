package com.example.securitysystemcoreservice.Services;

import com.example.securitysystemcoreservice.Repositories.ColonoRepository;
import com.example.securitysystemcoreservice.Models.Colono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.securitysystemcoreservice.Services.exceptions.ColonoNotFoundException;
import java.util.Optional;

@Service
public class ColonoService {
    private final ColonoRepository colonoRepository;

    @Autowired
    public ColonoService(ColonoRepository colonoRepository) {
        this.colonoRepository = colonoRepository;
    }

    public List<Colono> getColonos() {
        return this.colonoRepository.findAll();
    }

    public Colono addColono(Colono colono) {
        return this.colonoRepository.save(colono);
    }

    public void deleteColono(Long id) {
        this.colonoRepository.deleteById(id);
    }

    public Colono getColonoById(Long id) throws ColonoNotFoundException {
        Optional<Colono> colono = this.colonoRepository.findById(id);

        if (colono.isEmpty()) {
            throw new ColonoNotFoundException("Colono not found");
        }

        return colono.get();
    }

    public Colono updateColono(Long id, Colono colono) throws ColonoNotFoundException {
        boolean colonoExists = this.doesColonoExist(id);

        if (!colonoExists) {
            throw new ColonoNotFoundException("Colono not found");
        }

        colono.setId(id);

        return this.colonoRepository.save(colono);
    }

    private boolean doesColonoExist(Long id) {

        return this.colonoRepository.findById(id).isPresent();
    }
    
}
