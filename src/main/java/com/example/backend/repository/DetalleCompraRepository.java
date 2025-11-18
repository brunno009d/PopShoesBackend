package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.DetalleCompra;



public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long>{
    
}
