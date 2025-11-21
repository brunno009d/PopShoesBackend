package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Imagen;
import com.example.backend.service.ImagenService;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @GetMapping
    public ResponseEntity<List<Imagen>> obtenerTodos() {
        List<Imagen> list = imagenService.obtenerTodos();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> obtenerPorId(@PathVariable Integer id) {
        Imagen i = imagenService.obtenerPorId(id);
        if (i == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(i);
    }

    @PostMapping
    public ResponseEntity<Imagen> crear(@RequestBody Imagen imagen) {
        Imagen creado = imagenService.crear(imagen);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagen> actualizar(@PathVariable Integer id, @RequestBody Imagen imagen) {
        Imagen existente = imagenService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        Imagen guardado = imagenService.actualizar(id, imagen);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Imagen existente = imagenService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        boolean ok = imagenService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
