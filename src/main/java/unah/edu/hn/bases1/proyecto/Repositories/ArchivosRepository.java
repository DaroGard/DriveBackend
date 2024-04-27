package unah.edu.hn.bases1.proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.hn.bases1.proyecto.Entities.Archivos;

@Repository
public interface ArchivosRepository extends CrudRepository<Archivos, Integer> {

}
