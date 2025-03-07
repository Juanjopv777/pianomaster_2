package com.java.pianomaster.interfaces;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.pianomaster.entidades.Usuario;
import com.java.pianomaster.repositorios.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("Buscando usuario con email: " + username);
    Usuario usuario = usuarioRepository.findByEmail(username);
    if (usuario == null) {
        System.out.println("Usuario no encontrado.");
        throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + username);
    }
    System.out.println("Usuario encontrado: " + usuario.getEmail());
    return User.builder()
            .username(usuario.getEmail())
            .password(usuario.getPassword())
            .build();
}

}