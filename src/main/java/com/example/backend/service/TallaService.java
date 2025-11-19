package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Talla;
import com.example.backend.repository.TallaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TallaService extends AbstractBaseService<Talla, Integer> {

    public TallaService(TallaRepository tallaRepository) {
        super(tallaRepository);
    }
}
