package com.si.apirest.model.entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    
    @ManyToOne
    @JsonIgnore
    private Departament departament;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank(message = "Atributo nombre requerido.")
    private String nombre;

    @OneToMany(mappedBy = "category")
    private List<Producto> producto;

}
