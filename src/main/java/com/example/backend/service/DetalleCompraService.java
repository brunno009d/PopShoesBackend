package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.DetalleCompra;
import com.example.backend.repository.DetalleCompraRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetalleCompraService extends AbstractBaseService<DetalleCompra, Integer> {

    public DetalleCompraService(DetalleCompraRepository detalleCompraRepository) {
        super(detalleCompraRepository);
    }
}
