package com.java.pianomaster.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.pianomaster.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}