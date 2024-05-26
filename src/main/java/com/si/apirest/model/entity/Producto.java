package com.si.apirest.model.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Atributo nombre requerido")
    private String nombre;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;
    
    private String imagen;

    @ManyToOne
    private Category category;
    @ManyToOne
    private Descuento descuento;
    @OneToOne(mappedBy = "producto")
    @JsonIgnore
    private Inventario inventario;
}
