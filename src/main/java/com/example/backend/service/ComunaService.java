package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Comuna;
import com.example.backend.repository.ComunaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComunaService extends AbstractBaseService<Comuna, Integer> {

    public ComunaService(ComunaRepository comunaRepository) {
        super(comunaRepository);
    }
}
