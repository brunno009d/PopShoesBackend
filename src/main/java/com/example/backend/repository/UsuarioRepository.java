package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Usuario findByCorreo(String correo);

    boolean existsByCorreo(String correo);

    boolean existsByNombre(String nombre);

    /*
    findByNombreContaining(String nombre)   
    Query personalizada para traer usuarios con calzados
    Query con join para influencers
    */
}