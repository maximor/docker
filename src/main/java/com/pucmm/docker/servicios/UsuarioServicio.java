package com.pucmm.docker.servicios;

import com.pucmm.docker.entidades.Usuario;
import com.pucmm.docker.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Optional<Usuario> getUsuario(String usuario) {
        return usuarioRepository.findById(usuario);
    }

    public Usuario guardar(Usuario usuario) {
        usuario.setContraisenia(bCryptPasswordEncoder.encode(usuario.getContraisenia()));

        return usuarioRepository.save(usuario);
    }
}
