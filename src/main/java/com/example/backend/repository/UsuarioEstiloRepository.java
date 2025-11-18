package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.UsuarioEstilo;


@Repository
public interface UsuarioEstiloRepository extends JpaRepository<UsuarioEstilo, Long>{
    
}