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

import com.example.backend.model.MetodoEnvio;
import com.example.backend.service.MetodoEnvioService;

@RestController
@RequestMapping("/api/metodos-envio")
public class MetodoEnvioController {

    @Autowired
    private MetodoEnvioService metodoEnvioService;

    @GetMapping
    public ResponseEntity<List<MetodoEnvio>> obtenerTodos() {
        List<MetodoEnvio> list = metodoEnvioService.obtenerTodos();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoEnvio> obtenerPorId(@PathVariable Integer id) {
        MetodoEnvio m = metodoEnvioService.obtenerPorId(id);
        if (m == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @PostMapping
    public ResponseEntity<MetodoEnvio> crear(@RequestBody MetodoEnvio metodoEnvio) {
        MetodoEnvio creado = metodoEnvioService.crear(metodoEnvio);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoEnvio> actualizar(@PathVariable Integer id, @RequestBody MetodoEnvio metodoEnvio) {
        MetodoEnvio existente = metodoEnvioService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        MetodoEnvio guardado = metodoEnvioService.actualizar(id, metodoEnvio);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        MetodoEnvio existente = metodoEnvioService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        boolean ok = metodoEnvioService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
