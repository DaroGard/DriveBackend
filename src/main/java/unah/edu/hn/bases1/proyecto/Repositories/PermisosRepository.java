package unah.edu.hn.bases1.proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.hn.bases1.proyecto.Entities.Permisos;

@Repository
public interface PermisosRepository extends CrudRepository<Permisos, Integer> {

}
