package unah.edu.hn.bases1.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import unah.edu.hn.bases1.proyecto.Entities.Archivo;
import unah.edu.hn.bases1.proyecto.Entities.Usuario;

public interface ArchivoRepository extends CrudRepository<Archivo, Integer> {

    List<Archivo> findByUsuario(Usuario usuario);

    Archivo findByNombre(String nombre);

    @Query("SELECT a FROM Archivo a WHERE a.tipoArchivo.idTipoArchivo = :idTipoArchivo")
    List<Archivo> findArchivosByTipoArchivoId(@Param("idTipoArchivo") Integer idTipoArchivo);

}
