package com.si.apirest.model.dto;

import lombok.Data;

@Data
public class PersonDTO {

    private int id;

    private String nombre;

    private String usuario;
    
    private String email;

    private String direccion;

}
