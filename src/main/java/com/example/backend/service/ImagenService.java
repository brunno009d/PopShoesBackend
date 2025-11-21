package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Imagen;
import com.example.backend.repository.ImagenRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImagenService extends AbstractBaseService<Imagen, Integer> {

    private final ImagenRepository imagenRepository;

    public ImagenService(ImagenRepository imagenRepository) {
        super(imagenRepository);
        this.imagenRepository = imagenRepository;
    }

    public Imagen partialUpdate(Imagen imagen) {
        if (imagen == null || imagen.getId() == null) {
            return null;
        }

        Imagen existente = imagenRepository.findById(imagen.getId()).orElse(null);
        if (existente == null) {
            return null;
        }

        if (imagen.getTitulo() != null) {
            existente.setTitulo(imagen.getTitulo());
        }
        if (imagen.getUrl() != null) {
            existente.setUrl(imagen.getUrl());
        }
        if (imagen.getCalzado() != null) {
            existente.setCalzado(imagen.getCalzado());
        }

        return imagenRepository.save(existente);
    }
}
