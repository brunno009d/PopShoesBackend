package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Usuario;
import com.example.backend.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    public List<Usuario> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public Usuario findById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null){
            usuario.setContrasena(null);
        }
        return usuario;
    }

    

}
