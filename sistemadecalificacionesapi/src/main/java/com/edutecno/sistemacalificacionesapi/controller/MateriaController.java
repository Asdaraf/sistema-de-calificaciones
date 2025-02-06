package com.edutecno.sistemacalificacionesapi.controller;

import com.edutecno.sistemacalificacionesapi.entity.Materia;
import com.edutecno.sistemacalificacionesapi.service.MateriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @PostMapping
    public ResponseEntity<Materia> createMateria(@RequestBody Materia materia) {
        Materia nuevaMateria = materiaService.save(materia);
        return ResponseEntity.ok(nuevaMateria);
    }

    @GetMapping
    public ResponseEntity<List<Materia>> getAllMaterias() {
        return ResponseEntity.ok(materiaService.findAll());
    }
}
