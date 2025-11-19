package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Categoria;
import com.example.backend.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaService extends AbstractBaseService<Categoria, Integer> {

    public CategoriaService(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
    }
}
