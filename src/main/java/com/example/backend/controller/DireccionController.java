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

import com.example.backend.model.Direccion;
import com.example.backend.service.DireccionService;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<List<Direccion>> obtenerTodos() {
        List<Direccion> list = direccionService.obtenerTodos();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> obtenerPorId(@PathVariable Integer id) {
        Direccion d = direccionService.obtenerPorId(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }

    @PostMapping
    public ResponseEntity<Direccion> crear(@RequestBody Direccion direccion) {
        Direccion creado = direccionService.crear(direccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> actualizar(@PathVariable Integer id, @RequestBody Direccion direccion) {
        Direccion existente = direccionService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        Direccion guardado = direccionService.actualizar(id, direccion);
        return ResponseEntity.ok(guardado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Direccion> editar(@PathVariable Integer id, @RequestBody Direccion direccion) {
        Direccion actDireccion = direccionService.partialUpdate(direccion);
        if (actDireccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actDireccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Direccion existente = direccionService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        boolean ok = direccionService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
