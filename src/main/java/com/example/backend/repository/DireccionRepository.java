package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Direccion;



public interface DireccionRepository extends JpaRepository<Direccion, Long>{
    
}