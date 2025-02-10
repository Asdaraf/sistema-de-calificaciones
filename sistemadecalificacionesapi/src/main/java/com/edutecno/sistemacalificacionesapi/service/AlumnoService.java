package com.edutecno.sistemacalificacionesapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edutecno.sistemacalificacionesapi.dto.AlumnoDTO;
import com.edutecno.sistemacalificacionesapi.entity.Alumno;
import com.edutecno.sistemacalificacionesapi.entity.Materia;
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

    public List<AlumnoDTO> findAll() {
        logger.info("Obteniendo todos los alumnos");
        return alumnoRepository.findAll().stream()
            .map(alumno -> new AlumnoDTO(
                alumno.getId(),
                alumno.getRut(),
                alumno.getNombre(),
                alumno.getDireccion(),
                alumno.getMateriaList().stream().map(Materia::getNombre).collect(Collectors.toSet())
            )).collect(Collectors.toList());
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
