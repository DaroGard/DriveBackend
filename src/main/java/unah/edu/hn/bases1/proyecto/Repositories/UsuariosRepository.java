package unah.edu.hn.bases1.proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.hn.bases1.proyecto.Entities.Usuarios;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, Integer> {

    Usuarios findByCorreo(String correo);

}
