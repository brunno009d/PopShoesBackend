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

import com.example.backend.model.RolEstilo;
import com.example.backend.service.RolEstiloService;

@RestController
@RequestMapping("/api/rol-estilos")
public class RolEstiloController {

    @Autowired
    private RolEstiloService rolEstiloService;

    @GetMapping
    public ResponseEntity<List<RolEstilo>> obtenerTodos() {
        List<RolEstilo> list = rolEstiloService.obtenerTodos();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolEstilo> obtenerPorId(@PathVariable Integer id) {
        RolEstilo r = rolEstiloService.obtenerPorId(id);
        if (r == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(r);
    }

    @PostMapping
    public ResponseEntity<RolEstilo> crear(@RequestBody RolEstilo rolEstilo) {
        RolEstilo creado = rolEstiloService.crear(rolEstilo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolEstilo> actualizar(@PathVariable Integer id, @RequestBody RolEstilo rolEstilo) {
        RolEstilo existente = rolEstiloService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        RolEstilo guardado = rolEstiloService.actualizar(id, rolEstilo);
        return ResponseEntity.ok(guardado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RolEstilo> editar(@PathVariable Integer id, @RequestBody RolEstilo rolEstilo) {
        RolEstilo actRolEstilo = rolEstiloService.partialUpdate(rolEstilo);
        if (actRolEstilo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actRolEstilo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        RolEstilo existente = rolEstiloService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        boolean ok = rolEstiloService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
