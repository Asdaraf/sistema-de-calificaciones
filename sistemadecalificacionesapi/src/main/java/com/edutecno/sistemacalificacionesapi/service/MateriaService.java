package com.edutecno.sistemacalificacionesapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edutecno.sistemacalificacionesapi.entity.Materia;
import com.edutecno.sistemacalificacionesapi.repository.MateriaRepository;

@Service
public class MateriaService {

    private static final Logger logger = LoggerFactory.getLogger(MateriaService.class);

    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public Materia save(Materia materia) {
        logger.info("Guardando materia: {}", materia.getNombre());
        return materiaRepository.save(materia);
    }

    public List<Materia> findAll() {
        logger.info("Obteniendo todas las materias");
        return materiaRepository.findAll();
    }

}
