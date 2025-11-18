package com.example.backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Talla{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", nullable = false)
    private Long numero;

    @ManyToMany
    @JoinTable(
        name = "tallas_calzados",
        joinColumns = @JoinColumn(name = "id_talla", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "id_calzado", nullable = false)
    )
    private List<Calzado> calzados;
}