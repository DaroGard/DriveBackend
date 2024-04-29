package unah.edu.hn.bases1.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Usuarios;
import unah.edu.hn.bases1.proyecto.services.imp.UsuariosServiceImp;

@RestController
@RequestMapping("/drive")
public class UsuariosControllers {

    @Autowired
    private UsuariosServiceImp usuariosServiceImp;

    @PostMapping("/registro")
    public Usuarios registrarUsuarios(@RequestBody Usuarios usuario) {
        return usuariosServiceImp.registrarUsuario(usuario);
    }

    @PostMapping("/inicioSesion/verificacion")
    public Usuarios verificarUsuarios(@RequestParam String correo, @RequestParam String clave) {
        return usuariosServiceImp.verificarUsuario(correo, clave);
    }

    @GetMapping("/usuarios/obtenerPorID")
    public Usuarios obtenerUsuario(@RequestParam int codigoUsuario) {
        return usuariosServiceImp.obtenerUsuario(codigoUsuario);
    }

    @GetMapping("/usuarios/todos")
    public List<Usuarios> obtenerUsuarios() {
        return usuariosServiceImp.obtenerUsuarios();
    }

    @DeleteMapping("/usuarios/eliminar")
    public String eliminarUsuario(@RequestParam int codigoUsuario) {
        return usuariosServiceImp.eliminarUsuario(codigoUsuario);
    }

    @PutMapping("usuarios/actualizar/{codigoUsuario}")
    public String actualizarUsuario(@PathVariable int codigoUsuario, @RequestBody Usuarios usuarioActualizado) {
        return usuariosServiceImp.actualizarUsuario(codigoUsuario, usuarioActualizado);
    }

}
