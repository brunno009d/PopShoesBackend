package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Genero;
import com.example.backend.repository.GeneroRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GeneroService extends AbstractBaseService<Genero, Integer> {

    public GeneroService(GeneroRepository generoRepository) {
        super(generoRepository);
    }
}
