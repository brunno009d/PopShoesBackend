package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Compra;
import com.example.backend.repository.CompraRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompraService extends AbstractBaseService<Compra, Integer> {

    public CompraService(CompraRepository compraRepository) {
        super(compraRepository);
    }
}
