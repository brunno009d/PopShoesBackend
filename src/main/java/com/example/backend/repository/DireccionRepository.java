package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Direccion;


@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer>{

}