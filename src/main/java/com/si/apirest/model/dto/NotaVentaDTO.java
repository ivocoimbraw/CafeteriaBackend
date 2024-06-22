package com.si.apirest.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.si.apirest.model.entity.DetalleVenta;
import com.si.apirest.model.entity.TipoPago;

import lombok.Data;

@Data
public class NotaVentaDTO {
    private int id;

    private LocalDateTime fecha;
    private String status;

    private TipoPago tipoPago;

    private List<DetalleVenta> detalleVenta;

    private PersonDTO person;

}
