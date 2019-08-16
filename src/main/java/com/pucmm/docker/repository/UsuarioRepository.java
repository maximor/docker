package com.pucmm.docker.repository;

import com.pucmm.docker.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    public Usuario findByUsuario(String usuario);
    //public Usuario findById(String usuario);
}
