package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Color;
import com.example.backend.repository.ColorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ColorService extends AbstractBaseService<Color, Integer> {

    public ColorService(ColorRepository colorRepository) {
        super(colorRepository);
    }
}
