package com.example.backend.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Calzado;
import com.example.backend.repository.CalzadoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CalzadoService extends AbstractBaseService<Calzado, Integer> {

    private final CalzadoRepository calzadoRepository;

    public CalzadoService(CalzadoRepository calzadoRepository) {
        super(calzadoRepository);
        this.calzadoRepository = calzadoRepository;
    }

    public List<Calzado> buscarPorNombre(String nombre) {
        return calzadoRepository.findByNombreContaining(nombre == null ? "" : nombre);
    }

    public List<Calzado> buscarPorMarca(Integer marcaId) {
        if (marcaId == null) return Collections.emptyList();
        return calzadoRepository.findByMarcaId(marcaId);
    }

    public List<Calzado> buscarPorGenero(Integer generoId) {
        if (generoId == null) return Collections.emptyList();
        return calzadoRepository.findByGeneroId(generoId);
    }

    public List<Calzado> buscarPorPrecio(Long minimo, Long maximo) {
        if (minimo == null) minimo = 0L;
        if (maximo == null) maximo = Long.MAX_VALUE;
        return calzadoRepository.findByPrecioBetween(minimo, maximo);
    }

    public boolean tieneStock(Integer id, int cantidad) {
        return calzadoRepository.findById(id)
        .map(c -> c.getStock() != null && c.getStock() >= cantidad)
        .orElse(false);
    }

    public Calzado reducirStock(Integer id, int cantidad) {
        if (id == null || cantidad <= 0) return null;

        Calzado existente = calzadoRepository.findById(id).orElse(null);

        if (existente == null) return null;

        Integer stock = existente.getStock();
        if (stock == null || stock < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente");
        }

        existente.setStock(stock - cantidad);
        return calzadoRepository.save(existente);
    }

    public Calzado actualizarStock(Integer id, Integer nuevoStock) {
        if (id == null || nuevoStock == null) return null;
        Calzado existente = calzadoRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setStock(nuevoStock);
        return calzadoRepository.save(existente);
    }




}
