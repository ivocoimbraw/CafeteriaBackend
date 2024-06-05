package com.si.apirest.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class NotaEgreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private LocalDateTime  fecha;

    @OneToMany(mappedBy = "notaEgreso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleEgreso> detalleEgreso;
}
