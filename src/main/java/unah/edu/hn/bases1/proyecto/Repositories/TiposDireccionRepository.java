package unah.edu.hn.bases1.proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.hn.bases1.proyecto.Entities.TiposDireccion;

@Repository
public interface TiposDireccionRepository extends CrudRepository<TiposDireccion, Integer> {

}
