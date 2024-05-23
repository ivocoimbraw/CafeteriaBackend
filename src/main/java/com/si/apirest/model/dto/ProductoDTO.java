package com.si.apirest.model.dto;

import java.math.BigDecimal;

import com.si.apirest.model.entity.Descuento;

import lombok.Data;

@Data
public class ProductoDTO {
    private int id;
    private String nombre;
    private BigDecimal precio;
    private String imagen;
    private CategoryDTO category;
    private Descuento descuento;
}
