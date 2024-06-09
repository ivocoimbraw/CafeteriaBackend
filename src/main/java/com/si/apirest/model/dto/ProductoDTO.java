package com.si.apirest.model.dto;

import java.math.BigDecimal;

import com.si.apirest.model.entity.Descuento;
import com.si.apirest.model.entity.Imagen;

import lombok.Data;

@Data
public class ProductoDTO {
    private int id;
    private String nombre;
    private BigDecimal precio;
    private Imagen imagen;
    private CategoryDTO category;
    private Descuento descuento;
}
