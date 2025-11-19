package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Estilo;
import com.example.backend.repository.EstiloRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstiloService extends AbstractBaseService<Estilo, Integer> {

    public EstiloService(EstiloRepository estiloRepository) {
        super(estiloRepository);
    }
}
