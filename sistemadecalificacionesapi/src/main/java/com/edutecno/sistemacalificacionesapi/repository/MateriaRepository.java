package com.edutecno.sistemacalificacionesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.sistemacalificacionesapi.entity.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
