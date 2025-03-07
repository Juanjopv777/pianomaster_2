package com.java.pianomaster.interfaces;

import java.util.List;

import com.java.pianomaster.entidades.Estudiante;

public interface EstudianteInterfaz {
    List<Estudiante> listarTodosLosEstudiantes();
    Estudiante guardarEstudiante(Estudiante estudiante);
    Estudiante obtenerEstudiantePorId(Long id);
    Estudiante actualizarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(Long id); 

}
