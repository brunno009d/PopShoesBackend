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

import com.example.backend.model.Talla;
import com.example.backend.service.TallaService;

@RestController
@RequestMapping("/api/tallas")
public class TallaController {

    @Autowired
    private TallaService tallaService;

    @GetMapping
    public ResponseEntity<List<Talla>> obtenerTodos() {
        List<Talla> list = tallaService.obtenerTodos();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talla> obtenerPorId(@PathVariable Integer id) {
        Talla t = tallaService.obtenerPorId(id);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(t);
    }

    @PostMapping
    public ResponseEntity<Talla> crear(@RequestBody Talla talla) {
        Talla creado = tallaService.crear(talla);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Talla> actualizar(@PathVariable Integer id, @RequestBody Talla talla) {
        Talla existente = tallaService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        Talla guardado = tallaService.actualizar(id, talla);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Talla existente = tallaService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        boolean ok = tallaService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
