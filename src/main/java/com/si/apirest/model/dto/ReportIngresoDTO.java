package com.si.apirest.model.dto;

import lombok.Data;

@Data
public class ReportIngresoDTO {
    private String producto;
    private int cantidad;

    public ReportIngresoDTO(String producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

}
