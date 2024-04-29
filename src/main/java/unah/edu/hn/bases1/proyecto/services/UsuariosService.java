package unah.edu.hn.bases1.proyecto.services;

import java.util.List;

import unah.edu.hn.bases1.proyecto.Entities.Usuarios;

public interface UsuariosService {

    public Usuarios registrarUsuario(Usuarios usuario);

    public Usuarios verificarUsuario(String correo, String clave);

    public Usuarios obtenerUsuario(int codigoUsuario);

    public List<Usuarios> obtenerUsuarios();

    public String eliminarUsuario(int codigoUsuario);

    public String actualizarUsuario(int codigoUsuario, Usuarios usuarioActualizado);

}
