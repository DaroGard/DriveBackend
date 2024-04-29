package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Usuarios;
import unah.edu.hn.bases1.proyecto.Repositories.UsuariosRepository;
import unah.edu.hn.bases1.proyecto.services.UsuariosService;

@Service
public class UsuariosServiceImp implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public Usuarios registrarUsuario(Usuarios usuario) {
        Usuarios usuarioExistente = usuariosRepository.findByCorreo(usuario.getCorreo());
        if (usuarioExistente != null) {
            throw new IllegalArgumentException("El correo ya esta registrado");
        }

        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios verificarUsuario(String correo, String clave) {
        Usuarios usuario = usuariosRepository.findByCorreo(correo);

        if (usuario != null && clave.equals(usuario.getClave())) {
            return usuario;
        }
        return null;
    }

    @Override
    public Usuarios obtenerUsuario(int codigoUsuario) {
        return usuariosRepository.findById(codigoUsuario).orElse(null);
    }

    @Override
    public List<Usuarios> obtenerUsuarios() {
        return (List<Usuarios>) usuariosRepository.findAll();
    }

    @Override
    public String eliminarUsuario(int codigoUsuario) {
        if (this.usuariosRepository.existsById(codigoUsuario)) {
            usuariosRepository.deleteById(codigoUsuario);

            return "El cuenta eliminada.";
        }

        return "El usuario no existe";
    }

    @Override
    public String actualizarUsuario(int codigoUsuario, Usuarios usuarioActualizado) {

        Usuarios usuario = usuariosRepository.findById(codigoUsuario)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario."));

        if (usuarioActualizado.getNombre() != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
        }
        if (usuarioActualizado.getApellido() != null) {
            usuario.setApellido(usuarioActualizado.getApellido());
        }
        if (usuarioActualizado.getCorreo() != null) {
            usuario.setCorreo(usuarioActualizado.getCorreo());
        }
        if (usuarioActualizado.getClave() != null) {
            usuario.setClave(usuarioActualizado.getClave());
        }
        if (usuarioActualizado.getCorreoAdicional() != null) {
            usuario.setCorreoAdicional(usuarioActualizado.getCorreoAdicional());
        }
        if (usuarioActualizado.getFechaNacimiento() != null) {
            usuario.setFechaNacimiento(usuarioActualizado.getFechaNacimiento());
        }
        if (usuarioActualizado.getFormacion() != null) {
            usuario.setFormacion(usuarioActualizado.getFormacion());
        }
        if (usuarioActualizado.getGenero() != null) {
            usuario.setGenero(usuarioActualizado.getGenero());
        }
        if (usuarioActualizado.getTelefono() != null) {
            usuario.setTelefono(usuarioActualizado.getTelefono());
        }
        if (usuarioActualizado.getTrabajo() != null) {
            usuario.setTrabajo(usuarioActualizado.getTrabajo());
        }

        this.usuariosRepository.save(usuario);

        return "Datos actualizados";

    }
}
