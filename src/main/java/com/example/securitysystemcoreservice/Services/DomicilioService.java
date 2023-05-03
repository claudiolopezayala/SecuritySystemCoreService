package com.example.securitysystemcoreservice.Services;

import com.example.securitysystemcoreservice.Repositories.DomicilioRepository;
import com.example.securitysystemcoreservice.Models.Domicilio;
import com.example.securitysystemcoreservice.Services.exceptions.DomicilioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    private final DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public List<Domicilio> getDomicilios() {
        return this.domicilioRepository.findAll();
    }

    public Domicilio addDomicilio(Domicilio domicilio) {
        return this.domicilioRepository.save(domicilio);
    }

    public void deleteDomicilio(Long id) {
        this.domicilioRepository.deleteById(id);
    }

    public Domicilio getDomicilioById(Long id) throws DomicilioNotFoundException {
        Optional<Domicilio> domicilio = this.domicilioRepository.findById(id);

        if (domicilio.isEmpty()) {
            throw new DomicilioNotFoundException("Domicilio not found");
        }

        return domicilio.get();
    }

    public Domicilio updateDomicilio(Long id, Domicilio domicilio) throws DomicilioNotFoundException {
        boolean domicilioExists = this.doesDomicilioExist(id);

        if (!domicilioExists) {
            throw new DomicilioNotFoundException("Domicilio not found");
        }

        domicilio.setId(id);

        return this.domicilioRepository.save(domicilio);
    }
    private boolean doesDomicilioExist(Long id) {

        return this.domicilioRepository.findById(id).isPresent();
    }
}
