package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Calzado;


@Repository
public interface CalzadoRepository extends JpaRepository<Calzado, Integer>{

    //Query sobre los colores

    //Query sobre las tallas
    
    List<Calzado> findByNombreContaining(String nombre);

    List<Calzado> findByMarcaId(Integer marcaId);

    List<Calzado> findByGeneroId(Integer generoId);

    List<Calzado> findByPrecioBetween(Long precioMin, Long precioMax);

    //Categoria

    //Colores

    // 
}
    
