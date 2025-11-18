package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Calzado;


@Repository
public interface CalzadoRepository extends JpaRepository<Calzado, Long>{

}
    
