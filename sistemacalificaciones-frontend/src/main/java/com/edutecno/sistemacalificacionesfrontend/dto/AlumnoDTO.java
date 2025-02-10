package com.edutecno.sistemacalificacionesfrontend.dto;

import java.util.Set;

public class AlumnoDTO {
    private Long id;
    private String rut;
    private String nombre;
    private String direccion;
    private Set<String> materias; // Por ejemplo, solo los nombres de las materias

    public AlumnoDTO() {
    }

    public AlumnoDTO(Long id, String rut, String nombre, String direccion, Set<String> materias) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.materias = materias;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Set<String> getMaterias() { return materias; }
    public void setMaterias(Set<String> materias) { this.materias = materias; }
}

