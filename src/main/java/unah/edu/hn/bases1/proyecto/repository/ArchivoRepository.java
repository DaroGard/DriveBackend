package unah.edu.hn.bases1.proyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import unah.edu.hn.bases1.proyecto.Entities.Archivo;
import unah.edu.hn.bases1.proyecto.Entities.Usuario;

public interface ArchivoRepository extends CrudRepository<Archivo, Integer> {

    List<Archivo> findByUsuario(Usuario usuario);

    Archivo findByNombre(String nombre);

}
