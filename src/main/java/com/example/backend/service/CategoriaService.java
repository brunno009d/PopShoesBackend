package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Categoria;
import com.example.backend.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaService extends AbstractBaseService<Categoria, Integer> {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria partialUpdate(Categoria categoria) {
        if (categoria == null || categoria.getId() == null) {
            return null;
        }

        Categoria existente = categoriaRepository.findById(categoria.getId()).orElse(null);
        if (existente == null) {
            return null;
        }

        if (categoria.getNombre() != null) {
            existente.setNombre(categoria.getNombre());
        }
        if (categoria.getDescripcion() != null) {
            existente.setDescripcion(categoria.getDescripcion());
        }
        if (categoria.getCalzados() != null) {
            existente.setCalzados(categoria.getCalzados());
        }

        return categoriaRepository.save(existente);
    }
}
