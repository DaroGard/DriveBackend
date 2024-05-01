package unah.edu.hn.bases1.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import unah.edu.hn.bases1.proyecto.Entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    boolean existsByCorreo(String correo);

    Usuario findByCorreoAndContrasena(String correo, String contrasena);

}
