package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Direccion;
import com.example.backend.repository.DireccionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DireccionService extends AbstractBaseService<Direccion, Integer> {

    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        super(direccionRepository);
        this.direccionRepository = direccionRepository;
    }

    public Direccion partialUpdate(Direccion direccion) {
        if (direccion == null || direccion.getId() == null) {
            return null;
        }

        Direccion existente = direccionRepository.findById(direccion.getId()).orElse(null);
        if (existente == null) {
            return null;
        }

        if (direccion.getCalle() != null) {
            existente.setCalle(direccion.getCalle());
        }
        if (direccion.getNumero() != null) {
            existente.setNumero(direccion.getNumero());
        }
        if (direccion.getComuna() != null) {
            existente.setComuna(direccion.getComuna());
        }
        if (direccion.getUsuarios() != null) {
            existente.setUsuarios(direccion.getUsuarios());
        }

        return direccionRepository.save(existente);
    }
}
