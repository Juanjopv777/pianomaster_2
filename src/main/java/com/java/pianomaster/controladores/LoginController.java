package com.java.pianomaster.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.pianomaster.entidades.Usuario;
import com.java.pianomaster.interfaces.UsuarioService;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Página de inicio de sesión
    @GetMapping("/login")
    public String mostrarFormularioDeLogin(@RequestParam(value = "error", required = false) String error,
                                           @RequestParam(value = "logout", required = false) String logout,
                                           @RequestParam(value = "registroExitoso", required = false) String registroExitoso,
                                           Model model) {
        if (error != null) {
            model.addAttribute("error", "Credenciales inválidas. Intenta de nuevo.");
        }
        if (logout != null) {
            model.addAttribute("logout", "Has cerrado sesión exitosamente.");
        }
        if (registroExitoso != null) {
            model.addAttribute("registroExitoso", "¡Registro exitoso! Ahora puedes iniciar sesión.");
        }
        return "login";
    }

    // Página de registro
    @GetMapping("/registro")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    // Procesar registro
    @PostMapping("/registro")
    public String registrarUsuario(Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/login?registroExitoso"; // Redirige al login con un mensaje
    }

    // Página de inicio después del login exitoso
    @GetMapping("/inicio")
    public String mostrarPaginaDeInicio() {
        return "inicio"; // Asegúrate de que la vista "inicio.html" exista
    }

    @GetMapping("/nosotros")
    public String nosotros(){
     return "nosotros";
 }
 @GetMapping("/contacto")
 public String contacto(){
     return "contacto";
 }

 @GetMapping("/votaciones")
 public String votaciones(){
     return "votaciones";
 }

 @GetMapping("/candidato")
 public String candidato(){
     return "candidato";
 }
 @GetMapping("/dashboard")
 public String dashboard(){
     return "dashboard";
 }
}