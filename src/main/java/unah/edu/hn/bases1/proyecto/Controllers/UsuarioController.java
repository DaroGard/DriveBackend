package unah.edu.hn.bases1.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Usuario;
import unah.edu.hn.bases1.proyecto.services.imp.UsuarioServiceImpl;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario nvoUsuario) {
        Usuario usuario = this.usuarioServiceImpl.crearUsuario(nvoUsuario);
        return usuario;
    }

    @GetMapping("/obtenerTodos")
    public List<Usuario> obtenerTodos() {
        return this.usuarioServiceImpl.obtenertodos();
    }

    @GetMapping("/buscar/{idUsuario}")
    public Usuario buscarUsuario(@PathVariable(name = "idUsuario") int idUsuario) {
        return this.usuarioServiceImpl.obtenerUsuario(idUsuario);
    }
}
