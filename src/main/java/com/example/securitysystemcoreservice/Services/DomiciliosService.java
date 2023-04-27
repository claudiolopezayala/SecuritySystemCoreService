package com.example.securitysystemcoreservice.Services;

import com.example.securitysystemcoreservice.Repositories.DomicilioRepository;
import com.example.securitysystemcoreservice.Models.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public class DomiciliosService {
    private final DomicilioRepository domicilioRepository;

    @Autowired
    public DomiciliosService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public List<Domicilio> getDomicilios() {
        return this.domicilioRepository.findAll();
    }

    public Domicilio addDomicilio(Domicilio domicilio) throws DomicilioException {
        try {
            return this.domicilioRepository.save(domicilio);
        } catch (Exception e) {
            throw new DomicilioException("Email taken");
        }
    }

    public void deleteDomicilios(Long id) {
        this.domicilioRepository.deleteById(id);
    }

    public Domicilio getDomiciliosById(Long id) throws DomicilioNotFoundException {
        Optional<Domicilio> domicilio = this.domicilioRepository.findById(id);

        if (domicilio.isEmpty()) {
            throw new DomicilioNotFoundException("Domicilio not found");
        }

        return domicilio.get();
    }

    public Domicilio updateDomicilio(Long id, Domicilio domicilio) throws DomicilioNotFoundException, DomicilioException {
        boolean domicilioExists = this.doesDomicilioExist(id);

        if (!domicilioExists) {
            throw new DomicilioNotFoundException("Domicilio not found");
        }

        domicilio.setId(id);

        try {
            return this.domicilioRepository.save(domicilio);
        } catch (DataIntegrityViolationException e) {
            throw new DomicilioException("Unknown error");
        }
    }

}
