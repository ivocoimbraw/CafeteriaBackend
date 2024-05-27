package com.si.apirest.model.dto;

import lombok.Data;

@Data
public class DetalleIngresoDTO {
    private int cantidad;
    private InventarioIDTO inventario;
}
