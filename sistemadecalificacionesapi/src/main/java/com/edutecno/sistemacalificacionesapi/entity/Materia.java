package com.edutecno.sistemacalificacionesapi.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Materia {

    private Long id;
    private String nombre;
    private Alumno alumno;
}
