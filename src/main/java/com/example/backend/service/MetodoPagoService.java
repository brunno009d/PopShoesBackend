package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.MetodoPago;
import com.example.backend.repository.MetodoPagoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MetodoPagoService extends AbstractBaseService<MetodoPago, Integer> {

    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        super(metodoPagoRepository);
    }
}
