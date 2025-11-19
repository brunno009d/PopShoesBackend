package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Marca;
import com.example.backend.repository.MarcaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MarcaService extends AbstractBaseService<Marca, Integer> {

    public MarcaService(MarcaRepository marcaRepository) {
        super(marcaRepository);
    }
}
