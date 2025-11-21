package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.core.AbstractBaseService;
import com.example.backend.model.Calzado;
import com.example.backend.model.DetalleCompra;
import com.example.backend.repository.DetalleCompraRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetalleCompraService extends AbstractBaseService<DetalleCompra, Integer> {

    private final DetalleCompraRepository detalleCompraRepository;
    private final CalzadoService calzadoService;

    public DetalleCompraService(
        DetalleCompraRepository detalleCompraRepository,
        CalzadoService calzadoService
    ){
        super(detalleCompraRepository);
        this.detalleCompraRepository = detalleCompraRepository;
        this.calzadoService = calzadoService;
    }

    public DetalleCompra crearDetalleCompra(DetalleCompra detalleCompra) {

        // Guardar el detalle
        DetalleCompra nuevoDetalle = detalleCompraRepository.save(detalleCompra);

        // Verificar calzado asociado
        Calzado calzado = nuevoDetalle.getCalzado();
        if (calzado == null || calzado.getId() == null) {
            return nuevoDetalle; // no hay nada que actualizar
        }

        // Obtener calzado real desde BD
        Calzado calzadoBD = calzadoService.obtenerPorId(calzado.getId());
        if (calzadoBD == null) {
            return nuevoDetalle; // el calzado no existe en BD
        }

        // Actualizar stock
        int stockActual = calzadoBD.getStock() != null ? calzadoBD.getStock() : 0;
        int cantidad = nuevoDetalle.getCantidad() != null ? nuevoDetalle.getCantidad() : 0;

        // 👉 Aquí decides la lógica:
        // Si es una compra al proveedor → sumas
        // Si es una venta al cliente → restas

        calzadoBD.setStock(stockActual + cantidad); // o (stockActual - cantidad)

        // Guardar cambios del calzado
        calzadoService.crear(calzadoBD);

        return nuevoDetalle;
    }
}