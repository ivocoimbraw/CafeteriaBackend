package com.si.apirest.model.dto;

import java.time.LocalDateTime;
import java.util.List;


import lombok.Data;

@Data
public class NotaEgresoDTO {
    private String descripcion;
    private LocalDateTime fecha;
    private List<DetalleEgresoDTO> detalleEgreso;
}
