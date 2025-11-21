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

import com.example.backend.model.Comuna;
import com.example.backend.service.ComunaService;

@RestController
@RequestMapping("/api/comunas")
public class ComunaController {

    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<Comuna>> obtenerTodos() {
        List<Comuna> list = comunaService.obtenerTodos();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> obtenerPorId(@PathVariable Integer id) {
        Comuna c = comunaService.obtenerPorId(id);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Comuna> crear(@RequestBody Comuna comuna) {
        Comuna creado = comunaService.crear(comuna);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> actualizar(@PathVariable Integer id, @RequestBody Comuna comuna) {
        Comuna existente = comunaService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        Comuna guardado = comunaService.actualizar(id, comuna);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Comuna existente = comunaService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        boolean ok = comunaService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
