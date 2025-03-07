package com.java.pianomaster.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.pianomaster.entidades.Estudiante;
import com.java.pianomaster.interfaces.EstudianteInterfaz;

@Controller
public class EstudianteController {

     @Autowired
    private EstudianteInterfaz interfaz;

    // Listar todos los candidatos
    @GetMapping("/estudiantes")
    public String listarEstudiante(Model modelo){
        modelo.addAttribute("estudiantes", interfaz.listarTodosLosEstudiantes());
        return "estudiantes"; //retorna al archivo empleados
    }

    @GetMapping("/estudiantes/nuevo")
    public String crearEstudianteFormulario(Model modelo){
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante")Estudiante estudiante){
        interfaz.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";


    }

    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        Estudiante estudiante = interfaz.obtenerEstudiantePorId(id);
        if (estudiante == null) {
            // Redirige o muestra un mensaje de error si el empleado no existe
            return "redirect:/estudisante";
        }
        modelo.addAttribute("estudiante", estudiante);
        return "editar_estudiante";
    }

    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo){
        Estudiante estudianteExistente = interfaz.obtenerEstudiantePorId(id);
        if (estudianteExistente != null){
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());
        interfaz.actualizarEstudiante(estudianteExistente);
        }
        return "redirect:/estudiantes";

    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiantes(@PathVariable Long id){
        interfaz.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }

}
