package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEstilo {
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_estilo", nullable = false)
    private Estilo estilo;

    @ManyToOne
    @JoinColumn(name = "id_rol_estilo", nullable = false)
    private RolEstilo rolEstilo;
}