package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.RolEstilo;
import com.example.backend.repository.RolEstiloRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolEstiloService extends AbstractBaseService<RolEstilo, Integer> {

    private final RolEstiloRepository rolEstiloRepository;

    public RolEstiloService(RolEstiloRepository rolEstiloRepository) {
        super(rolEstiloRepository);
        this.rolEstiloRepository = rolEstiloRepository;
    }

    public RolEstilo partialUpdate(RolEstilo rolEstilo) {
        if (rolEstilo == null || rolEstilo.getId() == null) {
            return null;
        }

        RolEstilo existente = rolEstiloRepository.findById(rolEstilo.getId()).orElse(null);
        if (existente == null) {
            return null;
        }

        if (rolEstilo.getNombre() != null) {
            existente.setNombre(rolEstilo.getNombre());
        }

        return rolEstiloRepository.save(existente);
    }
}
