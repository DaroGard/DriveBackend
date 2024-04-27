package unah.edu.hn.bases1.proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.hn.bases1.proyecto.Entities.Planes;

@Repository
public interface PlanesRepository extends CrudRepository<Planes, Integer> {

}
