package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Genero;
import unah.edu.hn.bases1.proyecto.Entities.Usuario;
import unah.edu.hn.bases1.proyecto.dtos.Login;
import unah.edu.hn.bases1.proyecto.repository.GeneroRepository;
import unah.edu.hn.bases1.proyecto.repository.UsuarioRepository;
import unah.edu.hn.bases1.proyecto.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if (correoExistente(usuario.getCorreo())) {
            throw new IllegalArgumentException("Ya existe un usuario con este correo");
        }
        Genero genero = this.generoRepository.findById(usuario.getGenero().getIdGenero()).get();
        usuario.setGenero(genero);
        Usuario nvo = usuarioRepository.save(usuario);

        return usuario;
    }

    public boolean correoExistente(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    @Override
    public Usuario obtenerUsuario(int Usuario) {
        return this.usuarioRepository.findById(Usuario).get();
    }

    @Override
    public Usuario actualizarUsuario(Usuario Usuario, int id) {
        Usuario UsuarioActualizar = this.usuarioRepository.findById(id).get();
        if (UsuarioActualizar != null) {
            UsuarioActualizar.setNombre(Usuario.getNombre());
            UsuarioActualizar.setCorreo(Usuario.getCorreo());
            UsuarioActualizar.setContrasena(Usuario.getContrasena());
            UsuarioActualizar.setApellido(Usuario.getApellido());
            UsuarioActualizar.setTelefono(Usuario.getTelefono());
            this.usuarioRepository.save(UsuarioActualizar);
            return UsuarioActualizar;
        }
        return null;
    }

    @Override
    public Usuario loginUsuario(Login usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findByCorreoAndContrasena(usuario.getCorreo(),
                usuario.getContrasena());
        if (usuarioEncontrado != null) {
            return usuarioEncontrado;
        }
        return null;
    }

    @Override
    public List<Usuario> obtenertodos() {
        return this.usuarioRepository.findAll();
    }

}
