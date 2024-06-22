package com.si.apirest.model.entity;

import java.time.LocalDateTime;
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
public class NotaVenta {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private LocalDateTime fecha;
    private String status;

    @ManyToOne
    private TipoPago tipoPago;

    @OneToMany(mappedBy = "notaVenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;

    @ManyToOne
    private Person person;

}
