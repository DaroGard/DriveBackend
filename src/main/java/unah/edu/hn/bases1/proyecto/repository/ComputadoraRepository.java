package unah.edu.hn.bases1.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.hn.bases1.proyecto.Entities.Computadora;

@Repository
public interface ComputadoraRepository extends CrudRepository<Computadora, Integer>{
    
}
