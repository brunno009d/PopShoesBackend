package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Rol;
import com.example.backend.repository.RolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolService extends AbstractBaseService<Rol, Integer> {

    public RolService(RolRepository rolRepository) {
        super(rolRepository);
    }
}
