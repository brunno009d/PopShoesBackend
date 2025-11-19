package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer>{

}