package com.si.apirest.model.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class NotaIngreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private LocalDate fecha;

    @ManyToOne
    private Proveedor proveedor;
    @OneToMany(mappedBy = "notaIngreso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleIngreso> detalleIngreso;
}
