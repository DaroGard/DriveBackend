package unah.edu.hn.bases1.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Usuario;
import unah.edu.hn.bases1.proyecto.services.imp.UsuarioServiceImp;

@RestController
@RequestMapping("/drive/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImp usuarioServiceImpl;

    @GetMapping("/todos")
    public ResponseEntity<Iterable<Usuario>> obtenerTodosLosUsuarios() {
        Iterable<Usuario> usuarios = usuarioServiceImpl.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        Usuario usuario = usuarioServiceImpl.obtenerUsuarioPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> guardarUsuario(@Validated @RequestBody Usuario usuario) {
        if (usuarioServiceImpl.existePorCorreo(usuario.getCorreo())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ya está en uso.");
        }
        Usuario usuarioGuardado = usuarioServiceImpl.guardarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("id") Integer id) {
        usuarioServiceImpl.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("correo") String correo,
            @RequestParam("contrasena") String contrasena) {
        Usuario usuario = usuarioServiceImpl.encontrarPorCorreoYContrasena(correo, contrasena);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos.");
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable("id") Integer id,
            @Validated @RequestBody Usuario usuarioNuevo) {
        Usuario usuarioModificado = usuarioServiceImpl.modificarUsuario(id, usuarioNuevo);
        if (usuarioModificado != null) {
            return ResponseEntity.ok(usuarioModificado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}