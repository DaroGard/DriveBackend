package unah.edu.hn.bases1.proyecto.services;

import java.util.List;

import unah.edu.hn.bases1.proyecto.Entities.Usuario;
import unah.edu.hn.bases1.proyecto.dtos.Login;

public interface UsuarioService {

    public Usuario crearUsuario(Usuario usuario);

    public Usuario obtenerUsuario(int Usuario);

    public Usuario actualizarUsuario(Usuario Usuario, int id);

    public Usuario loginUsuario(Login usuario);

    public List<Usuario> obtenertodos();

}
