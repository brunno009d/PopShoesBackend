package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.RolEstilo;

@Repository
public interface RolEstiloRepository extends JpaRepository<RolEstilo, Integer> {
    
}
