package unah.edu.hn.bases1.proyecto.services;

import unah.edu.hn.bases1.proyecto.Entities.Usuario;

public interface UsuarioService {

    public Iterable<Usuario> obtenerTodosLosUsuarios();

    public Usuario obtenerUsuarioPorId(Integer id);

    public Usuario guardarUsuario(Usuario usuario);

    public void eliminarUsuario(Integer id);

    public boolean existePorCorreo(String correo);

    public Usuario encontrarPorCorreoYContrasena(String correo, String contrasena);

    public Usuario modificarUsuario(Integer id, Usuario usuario);

}
