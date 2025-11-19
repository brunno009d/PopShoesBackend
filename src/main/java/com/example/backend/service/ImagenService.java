package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Imagen;
import com.example.backend.repository.ImagenRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImagenService extends AbstractBaseService<Imagen, Integer> {

    public ImagenService(ImagenRepository imagenRepository) {
        super(imagenRepository);
    }
}
