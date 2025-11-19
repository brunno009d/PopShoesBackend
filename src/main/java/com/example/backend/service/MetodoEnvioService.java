package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.MetodoEnvio;
import com.example.backend.repository.MetodoEnvioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MetodoEnvioService extends AbstractBaseService<MetodoEnvio, Integer> {

    public MetodoEnvioService(MetodoEnvioRepository metodoEnvioRepository) {
        super(metodoEnvioRepository);
    }
}
