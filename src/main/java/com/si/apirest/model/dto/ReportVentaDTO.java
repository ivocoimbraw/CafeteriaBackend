package com.si.apirest.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ReportVentaDTO {
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;
    private Double subtotal;
    private Double descuento;

    public ReportVentaDTO(String nombre, Integer cantidad, BigDecimal precio, Double subtotal, Double descuento) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.descuento = descuento;
    }

}
