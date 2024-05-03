package unah.edu.hn.bases1.proyecto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import unah.edu.hn.bases1.proyecto.Entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Usuario u WHERE u.correo = ?1")
    boolean existsByCorreo(String correo);

    @Query("SELECT u FROM Usuario u WHERE u.correo = ?1 AND u.contrasena = ?2")
    Usuario findByCorreoAndContrasena(String correo, String contrasena);

}
