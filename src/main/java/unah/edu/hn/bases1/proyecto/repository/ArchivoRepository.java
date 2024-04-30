package unah.edu.hn.bases1.proyecto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.hn.bases1.proyecto.Entities.Archivo;

public interface ArchivoRepository extends JpaRepository<Archivo, Integer> {
    List<Archivo> findByPropietario_IdUsuario(int propietario);

    List<Archivo> findByTipoArchivo_IdTipoArchivoAndPropietario_IdUsuario(int tipoArchivo, int usuario);

    List<Archivo> findByFechaCreacionAndPropietario_IdUsuario(Date fechaCreacion, int usuario);

    // busca los archivos que esten dentro de la ubiacion dada
    List<Archivo> findByUbicacionArchivo_UbicacionPadre_IdUbicacion(int ubicacionPadre);

    // List<Archivo>
    // findByUbicacionArchivo_NombreUbicacionAndPropietario_IdUsuario(String nombre,
    // int propietario );
    List<Archivo> findByUbicacionArchivo_NombreUbicacionArchivoAndPropietario_IdUsuario(String nombre, int propietario);

    List<Archivo> findByEstadoArchivo_IdEstadoAndPropietario_IdUsuario(int estado, int propietario);

    List<Archivo> findByNombreAndPropietario_IdUsuario(String nombre, int propietario);

    List<Archivo> findAllByNombre(String nombre);

}
