package com.pucmm.docker;

import com.pucmm.docker.entidades.Usuario;
import com.pucmm.docker.repository.UsuarioRepository;
import com.pucmm.docker.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DockerApplication {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UsuarioServicio usuarioServicio;

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
    }

    @Bean
    public CommandLineRunner cargarDatos(UsuarioRepository repository) {
        return (args -> {
            Usuario usuario = new Usuario();

            usuario.setContraisenia("admin");
            usuario.setUsuario("admin");

            Usuario usuario1 = new Usuario();
            usuario1.setUsuario("usuario");
            usuario1.setContraisenia("usuario");
            usuarioServicio.guardar(usuario);
            usuarioServicio.guardar(usuario1);
        });
    }
}
