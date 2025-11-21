package com.example.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Calzado;
import com.example.backend.model.Compra;
import com.example.backend.model.DetalleCompra;
import com.example.backend.repository.CompraRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompraService extends AbstractBaseService<Compra, Integer> {

    private final CompraRepository compraRepository;
    private final DetalleCompraService detalleCompraService;
    private final CalzadoService calzadoService;

    public CompraService(
        CompraRepository compraRepository,
        DetalleCompraService detalleCompraService,
        CalzadoService calzadoService
    ) {
        super(compraRepository);
        this.compraRepository = compraRepository;
        this.detalleCompraService = detalleCompraService;
        this.calzadoService = calzadoService;
    }

    public Compra crearCompraConDetalles(Compra compra, List<DetalleCompra> detalles) {

        compra.setFecha(new Date());
        compra.setTotal(0L); 
        Compra compraGuardada = compraRepository.save(compra);
        long total = 0;

        for (DetalleCompra detalle : detalles) {

            detalle.setCompra(compraGuardada);

            Calzado calzado = calzadoService.obtenerPorId(detalle.getCalzado().getId());
            if (calzado == null) {
                throw new IllegalArgumentException("El calzado con ID " + detalle.getCalzado().getId() + " no existe.");
            }

            int cantidad = detalle.getCantidad();
            if (!calzadoService.tieneStock(calzado.getId(), cantidad)) {
                throw new IllegalArgumentException("Stock insuficiente para el calzado: " + calzado.getNombre());
            }

            calzadoService.reducirStock(calzado.getId(), cantidad);

            detalleCompraService.crear(detalle);

            long precio = calzado.getPrecio() != null ? calzado.getPrecio() : 0;
            total += (precio * cantidad);
        }

        compraGuardada.setTotal(total);
        return compraRepository.save(compraGuardada);
    }

    public Compra actualizarEstadoCompra(Integer id, Boolean nuevoEstado) {
        Compra compra = obtenerPorId(id);
        if (compra == null) return null;

        compra.setEstado(nuevoEstado);
        return compraRepository.save(compra);
    }
}

