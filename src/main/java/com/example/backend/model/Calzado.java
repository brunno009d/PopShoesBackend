package com.example.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Calzado {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private Long precio;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    @ManyToOne
    @JoinColumn(name= "id_genero", nullable = false)
    private Genero genero;

    @ManyToMany(mappedBy = "calzados")
    @JsonIgnore
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "calzados")
    @JsonIgnore
    private List<Color> colores;

    @ManyToMany(mappedBy = "calzados")
    @JsonIgnore
    private List<Estilo> estilos;

    @ManyToMany(mappedBy = "calzados")
    @JsonIgnore
    private List<Talla> tallas;

}