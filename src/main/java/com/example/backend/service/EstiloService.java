package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Estilo;
import com.example.backend.repository.EstiloRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstiloService extends AbstractBaseService<Estilo, Integer> {

    private final EstiloRepository estiloRepository;

    public EstiloService(EstiloRepository estiloRepository) {
        super(estiloRepository);
        this.estiloRepository = estiloRepository;
    }

    public Estilo partialUpdate(Estilo estilo) {
        if (estilo == null || estilo.getId() == null) {
            return null;
        }

        Estilo existente = estiloRepository.findById(estilo.getId()).orElse(null);
        if (existente == null) {
            return null;
        }

        if (estilo.getNombre() != null) {
            existente.setNombre(estilo.getNombre());
        }
        if (estilo.getDescripcion() != null) {
            existente.setDescripcion(estilo.getDescripcion());
        }
        if (estilo.getCalzados() != null) {
            existente.setCalzados(estilo.getCalzados());
        }

        return estiloRepository.save(existente);
    }
}
