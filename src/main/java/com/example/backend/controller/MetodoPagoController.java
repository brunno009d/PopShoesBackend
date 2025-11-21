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

import com.example.backend.model.MetodoPago;
import com.example.backend.service.MetodoPagoService;

@RestController
@RequestMapping("/api/metodos-pago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public ResponseEntity<List<MetodoPago>> obtenerTodos() {
        List<MetodoPago> list = metodoPagoService.obtenerTodos();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> obtenerPorId(@PathVariable Integer id) {
        MetodoPago m = metodoPagoService.obtenerPorId(id);
        if (m == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @PostMapping
    public ResponseEntity<MetodoPago> crear(@RequestBody MetodoPago metodoPago) {
        MetodoPago creado = metodoPagoService.crear(metodoPago);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> actualizar(@PathVariable Integer id, @RequestBody MetodoPago metodoPago) {
        MetodoPago existente = metodoPagoService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        MetodoPago guardado = metodoPagoService.actualizar(id, metodoPago);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        MetodoPago existente = metodoPagoService.obtenerPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        boolean ok = metodoPagoService.eliminar(id);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
