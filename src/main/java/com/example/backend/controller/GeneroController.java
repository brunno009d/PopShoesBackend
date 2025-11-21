package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Genero;
import com.example.backend.service.GeneroService;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {
    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<Genero>> getAllGenero(){
        List<Genero> generos = generoService.obtenerTodos();
        if (generos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(generos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable Integer id) {
        Genero genero = generoService.obtenerPorId(id);
        if (genero == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(genero);
    }

    @PostMapping
    public ResponseEntity<Genero> createGenero(Genero genero) {
        Genero createdGenero = generoService.crear(genero);
        return ResponseEntity.status(201).body(createdGenero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> updateGenero(@PathVariable Integer id, Genero genero) {
        Genero updatedGenero = generoService.actualizar(id, genero);
        if (updatedGenero == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedGenero);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Integer id) {
        generoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
