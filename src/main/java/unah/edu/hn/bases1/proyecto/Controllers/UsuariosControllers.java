package unah.edu.hn.bases1.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Usuarios;
import unah.edu.hn.bases1.proyecto.services.imp.UsuariosServiceImp;

@RestController
@RequestMapping("/drive")
public class UsuariosControllers {

    @Autowired
    private UsuariosServiceImp usuariosServiceImp;

    @PostMapping("/registro")
    public Usuarios registUsuarios(@RequestBody Usuarios usuario) {
        return usuariosServiceImp.registrarUsuario(usuario);
    }

    @PostMapping("path")
    public String postMethodName(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

}
