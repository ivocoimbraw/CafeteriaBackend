package com.si.apirest.model.entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
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
    private Departament departament;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank(message = "Atributo nombre requerido.")
    private String nombre;
}
