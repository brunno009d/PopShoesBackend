package com.example.backend.core;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;


// Se envia el id Para saber el tipo de Id que se maneja en cada entidad
// T es el tipo de entidad que se maneja
@Transactional
public abstract class AbstractBaseService<T, ID> {
    protected JpaRepository<T, ID> repository;

    public AbstractBaseService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T crear(T entidad) {
        return repository.save(entidad);
    }

    public T obtenerPorId(ID id) {
        return repository.findById(id).orElse(null);
    }

    public List<T> obtenerTodos() {
        return repository.findAll();
    }

    public T actualizar(ID id, T entidad) {
    if (repository.existsById(id)) {
        return repository.save(entidad);
        }
    return null;
    }

    public boolean eliminar(ID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
