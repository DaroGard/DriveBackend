package unah.edu.hn.bases1.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import unah.edu.hn.bases1.proyecto.Entities.Carpeta;
import unah.edu.hn.bases1.proyecto.Entities.EstadoCarpeta;

public interface CarpetaRepository extends CrudRepository<Carpeta, Integer> {

    @Query("SELECT c FROM Carpeta c WHERE c.nombreCarpeta = ?1")
    Carpeta findByNombreCarpeta(String nombreCarpeta);

    @Query("SELECT c FROM Carpeta c WHERE c.estadoCarpeta = ?1")
    Carpeta findByEstadoCarpeta(EstadoCarpeta estadoCarpeta);

    @Query("SELECT c FROM Carpeta c WHERE c.carpetaPadre.idCarpeta = ?1")
    Carpeta findByCarpetaPadreIdCarpeta(Integer idCarpetaPadre);

    @Query("SELECT c FROM Carpeta c WHERE c.carpetaPadre.idCarpeta = :idCarpeta")
    List<Carpeta> findCarpetasHijasByIdCarpeta(@Param("idCarpeta") Integer idCarpeta);

    @Query("SELECT c FROM Carpeta c WHERE c.nombreCarpeta = :nombreCarpeta AND c.idCarpeta <> :idCarpeta")
    public Carpeta findByNombreCarpetaAndIdCarpetaNot(@Param("nombreCarpeta") String nombreCarpeta,
            @Param("idCarpeta") Integer idCarpeta);

}
