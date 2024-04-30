package unah.edu.hn.bases1.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.hn.bases1.proyecto.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByCorreo(String correo);

    Usuario findByCorreoAndContrasena(String correo, String contrasena);
}
