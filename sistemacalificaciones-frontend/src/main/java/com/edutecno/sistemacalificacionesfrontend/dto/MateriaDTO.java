package com.edutecno.sistemacalificacionesfrontend.dto;

public class MateriaDTO {

    private Long id;
    private String nombre;
    private AlumnoDTO alumno; // Se asume que AlumnoDTO ya está creado en este paquete

    public MateriaDTO() {
    }

    public MateriaDTO(Long id, String nombre, AlumnoDTO alumno) {
        this.id = id;
        this.nombre = nombre;
        this.alumno = alumno;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public AlumnoDTO getAlumno() {
        return alumno;
    }
    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }
}
