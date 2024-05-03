package unah.edu.hn.bases1.proyecto.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import unah.edu.hn.bases1.proyecto.Entities.Archivo;
import unah.edu.hn.bases1.proyecto.Entities.Favorito;
import unah.edu.hn.bases1.proyecto.Entities.Usuario;

public interface FavoritoRepository extends CrudRepository<Favorito, Integer> {

    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM Favorito f WHERE f.usuario = :usuario AND f.archivo = :archivo")
    boolean existsByUsuarioAndArchivo(Usuario usuario, Archivo archivo);

    @Modifying
    @Query("DELETE FROM Favorito f WHERE f.archivo = :archivo")
    void deleteByArchivo(Archivo archivo);

}
