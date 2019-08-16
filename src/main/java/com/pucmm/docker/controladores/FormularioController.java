package com.pucmm.docker.controladores;

import com.pucmm.docker.entidadPublica;
import com.pucmm.docker.entidades.Formulario;
import com.pucmm.docker.entidades.Usuario;
import com.pucmm.docker.seguridad.CurrentUsuario;
import com.pucmm.docker.seguridad.UsuarioPrincipal;
import com.pucmm.docker.servicios.FormularioServicio;
import com.pucmm.docker.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormularioController {
    @Autowired
    FormularioServicio formularioServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @RequestMapping("formulario")
    public ModelAndView indice(@CurrentUsuario UsuarioPrincipal usuarioPrincipal, ModelAndView model) {
        entidadPublica entidadPublica = new entidadPublica();

        model.addObject("formulario", entidadPublica);
        model.addObject("usuario", usuarioPrincipal);
        model.setViewName("formulario");

        return model;
    }

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public String submit(@CurrentUsuario UsuarioPrincipal currentUser,
                         @RequestParam("resultado1") String resultado1,
                         @RequestParam("resultado2") String resultado2,
                         @RequestParam("resultado3") String resultado3,
                         @RequestParam("resultado4") String resultado4) {
        Usuario usuario = usuarioServicio.getUsuario(currentUser.getUsername()).orElse(null);

        if(usuario == null) {
            return "redirect:/login";
        }

        Formulario formulario = new Formulario();
        formulario.setResultado1(Integer.valueOf(resultado1));
        formulario.setResultado2(Integer.valueOf(resultado2));
        formulario.setResultado3(Integer.valueOf(resultado3));
        formulario.setResultado4(Integer.valueOf(resultado4));
        formulario.setPregunta1("1");
        formulario.setPregunta2("2");
        formulario.setPregunta3("3");
        formulario.setPregunta4("4");
        formulario.setUsuario(usuario);

        formularioServicio.guardar(formulario);

        return "redirect:/formulario";
    }
}
