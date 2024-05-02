package unah.edu.hn.bases1.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import unah.edu.hn.bases1.proyecto.Entities.Carpeta;
import unah.edu.hn.bases1.proyecto.Entities.EstadoCarpeta;

public interface CarpetaRepository extends CrudRepository<Carpeta, Integer> {

    public Carpeta findByNombreCarpeta(String nombreCarpeta);

    public Carpeta findByEstadoCarpeta(EstadoCarpeta estadoCarpeta);

    public Carpeta findByCarpetaPadreIdCarpeta(Integer idCarpetaPadre);

    @Query("SELECT c FROM Carpeta c WHERE c.carpetaPadre.idCarpeta = :idCarpeta")
    List<Carpeta> findCarpetasHijasByIdCarpeta(@Param("idCarpeta") Integer idCarpeta);

    @Query("SELECT c FROM Carpeta c WHERE c.nombreCarpeta = :nombreCarpeta AND c.idCarpeta <> :idCarpeta")
    public Carpeta findByNombreCarpetaAndIdCarpetaNot(@Param("nombreCarpeta") String nombreCarpeta,
            @Param("idCarpeta") Integer idCarpeta);

}
