package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Calzado;
import com.example.backend.service.CalzadoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/calzados")
public class CalzadoController {
    @Autowired
    private CalzadoService calzadoService;

    @GetMapping
    public ResponseEntity<List<Calzado>> getAllCalzados(){
        List<Calzado> calzados = calzadoService.obtenerTodos();
        if (calzados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(calzados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calzado> getCalzadoById(@PathVariable Integer id) {
        Calzado calzado = calzadoService.obtenerPorId(id);
        if (calzado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(calzado);
    }

    @PostMapping
    public ResponseEntity<Calzado> guardar(@RequestBody Calzado calzado){
        Calzado nuevoCalzado = calzadoService.crear(calzado);
        if (nuevoCalzado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nuevoCalzado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calzado> actualizar(@PathVariable Integer id, @RequestBody Calzado calzado){
        Calzado actCalzado = calzadoService.actualizar(id, calzado);
        if (actCalzado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actCalzado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Calzado> editar(@PathVariable Long id, @RequestBody Calzado calzado){
        Calzado actCalzado = calzadoService.partialUpdate(calzado);
        if (actCalzado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actCalzado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        Calzado calzado = calzadoService.obtenerPorId(id);
        if (calzado == null){
            return ResponseEntity.notFound().build();
        }
        calzadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
