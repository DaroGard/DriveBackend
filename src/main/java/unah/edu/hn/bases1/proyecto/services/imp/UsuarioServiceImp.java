package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Genero;
import unah.edu.hn.bases1.proyecto.Entities.Lugar;
import unah.edu.hn.bases1.proyecto.Entities.Preferencia;
import unah.edu.hn.bases1.proyecto.Entities.Usuario;
import unah.edu.hn.bases1.proyecto.repository.GeneroRepository;
import unah.edu.hn.bases1.proyecto.repository.LugarRepository;
import unah.edu.hn.bases1.proyecto.repository.PreferenciaRepository;
import unah.edu.hn.bases1.proyecto.repository.UsuarioRepository;
import unah.edu.hn.bases1.proyecto.services.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private LugarRepository lugarRepository;

    @Autowired
    private PreferenciaRepository preferenciaRepository;

    @Override
    public Iterable<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está en uso.");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public boolean existePorCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    @Override
    public Usuario encontrarPorCorreoYContrasena(String correo, String contrasena) {
        return usuarioRepository.findByCorreoAndContrasena(correo, contrasena);
    }

    @Override
    public Usuario modificarUsuario(Integer id, Usuario usuarioNuevo) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioExistente = optionalUsuario.get();
            usuarioExistente.setNombre(usuarioNuevo.getNombre());
            usuarioExistente.setApellido(usuarioNuevo.getApellido());
            usuarioExistente.setContrasena(usuarioNuevo.getContrasena());

            if (usuarioNuevo.getGenero() != null) {
                Optional<Genero> optionalGenero = generoRepository.findById(usuarioNuevo.getGenero().getIdGenero());
                optionalGenero.ifPresent(usuarioExistente::setGenero);
            }

            if (usuarioNuevo.getLugar() != null) {
                Optional<Lugar> optionalLugar = lugarRepository.findById(usuarioNuevo.getLugar().getIdLugar());
                optionalLugar.ifPresent(usuarioExistente::setLugar);
            }

            if (usuarioNuevo.getPreferencia() != null) {
                Optional<Preferencia> optionalPreferencia = preferenciaRepository
                        .findById(usuarioNuevo.getPreferencia().getIdPreferencia());
                optionalPreferencia.ifPresent(usuarioExistente::setPreferencia);
            }

            usuarioExistente.setImagen(usuarioNuevo.getImagen());
            usuarioExistente.setTelefono(usuarioNuevo.getTelefono());
            return usuarioRepository.save(usuarioExistente);
        } else {
            return null;
        }
    }
}