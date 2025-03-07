package com.java.pianomaster.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.pianomaster.entidades.Estudiante;
import com.java.pianomaster.repositorios.*;

@Service 
public class EstudianteImplementacion implements EstudianteInterfaz {

     @Autowired
    private EstudianteRepositorio repositorio;

    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        return repositorio.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) { // Usamos Long
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) { // Usamos Long
        repositorio.deleteById(id);
    }

}
