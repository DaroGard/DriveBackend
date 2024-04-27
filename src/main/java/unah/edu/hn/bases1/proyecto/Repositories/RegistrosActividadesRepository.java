package unah.edu.hn.bases1.proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.hn.bases1.proyecto.Entities.RegistrosActividades;

@Repository
public interface RegistrosActividadesRepository extends CrudRepository<RegistrosActividades, Integer> {

}
