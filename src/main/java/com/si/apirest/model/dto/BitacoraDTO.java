package com.si.apirest.model.dto;

import java.util.GregorianCalendar;

import lombok.Data;

@Data
public class BitacoraDTO {
    
    private Integer id;
    private GregorianCalendar fecha;
    private String accion;
    private PersonDTO user;
}
