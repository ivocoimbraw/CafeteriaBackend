package com.si.apirest.model.dto;

import java.util.GregorianCalendar;
import java.util.List;

import com.si.apirest.model.entity.Proveedor;

import lombok.Data;

@Data
public class NotaIngresoDTO {
    private String descripcion;
    private GregorianCalendar fecha;
    private Proveedor proveedor;
    private List<DetalleIngresoDTO> detalleIngreso;
}
