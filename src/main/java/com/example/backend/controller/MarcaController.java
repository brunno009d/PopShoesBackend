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

import com.example.backend.model.Marca;
import com.example.backend.service.MarcaService;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> obtenerTodos() {
        List<Marca> list = marcaService.obtenerTodos();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> obtenerPorId(@PathVariable Integer id) {
        Marca m = marcaService.obtenerPorId(id);
        if (m == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @PostMapping
    public ResponseEntity<Marca> crear(@RequestBody Marca marca) {
        Marca creado = marcaService.crear(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> actualizar(@PathVariable Integer id, @RequestBody Marca marca) {
        Marca existente = marcaService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        Marca guardado = marcaService.actualizar(id, marca);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Marca existente = marcaService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        boolean ok = marcaService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
