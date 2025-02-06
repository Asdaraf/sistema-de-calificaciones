package com.edutecno.sistemacalificacionesapi.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edutecno.sistemacalificacionesapi.entity.Alumno;
import com.edutecno.sistemacalificacionesapi.repository.AlumnoRepository;

@Service
public class AlumnoService {

    private static final Logger logger = LoggerFactory.getLogger(AlumnoService.class);

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public Alumno save(Alumno alumno) {
        logger.info("Guardando alumno: {}", alumno.getNombre());
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> findAll() {
        logger.info("Obteniendo todos los alumnos");
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> findById(Long id) {
        logger.info("Buscando alumno con ID: {}", id);
        return alumnoRepository.findById(id);
    }

    public void deleteById(Long id) {
        logger.info("Eliminando alumno con ID: {}", id);
        alumnoRepository.deleteById(id);
    }
}
