package com.si.apirest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DetalleEgreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "notaEgreso_id", nullable = false)
    @JsonIgnore
    private NotaEgreso notaEgreso;

    @ManyToOne
    @JoinColumn(name = "inventario_id", nullable = false)
    private Inventario inventario;
}
