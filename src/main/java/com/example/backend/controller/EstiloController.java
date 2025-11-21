package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Estilo;
import com.example.backend.service.EstiloService;

@RestController
@RequestMapping("/api/estilos")
public class EstiloController {

    @Autowired
    private EstiloService estiloService;

    @GetMapping
    public ResponseEntity<List<Estilo>> obtenerTodos() {
        List<Estilo> list = estiloService.obtenerTodos();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estilo> obtenerPorId(@PathVariable Integer id) {
        Estilo e = estiloService.obtenerPorId(id);
        if (e == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(e);
    }

    @PostMapping
    public ResponseEntity<Estilo> crear(@RequestBody Estilo estilo) {
        Estilo creado = estiloService.crear(estilo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estilo> actualizar(@PathVariable Integer id, @RequestBody Estilo estilo) {
        Estilo existente = estiloService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        Estilo guardado = estiloService.actualizar(id, estilo);
        return ResponseEntity.ok(guardado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Estilo> editar(@PathVariable Integer id, @RequestBody Estilo estilo) {
        Estilo actEstilo = estiloService.partialUpdate(estilo);
        if (actEstilo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actEstilo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Estilo existente = estiloService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        boolean ok = estiloService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
