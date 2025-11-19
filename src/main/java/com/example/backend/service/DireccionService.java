package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Direccion;
import com.example.backend.repository.DireccionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DireccionService extends AbstractBaseService<Direccion, Integer> {

    public DireccionService(DireccionRepository direccionRepository) {
        super(direccionRepository);
    }
}
