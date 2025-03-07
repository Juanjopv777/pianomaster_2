package com.java.pianomaster.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.pianomaster.entidades.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {

}
