package com.si.apirest.model.dto;

import lombok.Data;

@Data
public class DetalleEgresoDTO {
    private int cantidad;
    private InventarioIDTO inventario;
}
