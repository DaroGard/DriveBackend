package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Archivo;
import unah.edu.hn.bases1.proyecto.Entities.Favorito;
import unah.edu.hn.bases1.proyecto.Entities.Usuario;
import unah.edu.hn.bases1.proyecto.repository.FavoritoRepository;
import unah.edu.hn.bases1.proyecto.services.FavoritoService;

@Service
public class FavoritoServiceImp implements FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    public Favorito agregarFavorito(Favorito favorito) {
        Usuario usuario = favorito.getUsuario();
        Archivo archivo = favorito.getArchivo();

        boolean favoritoExistente = favoritoRepository.existsByUsuarioAndArchivo(usuario, archivo);

        if (!favoritoExistente) {
            favorito.setFechaAgregado(new Date());
            return favoritoRepository.save(favorito);
        } else {
            throw new IllegalArgumentException("Ya existe un favorito para este usuario y archivo");
        }
    }

    @Override
    public List<Favorito> obtenerFavoritos() {
        return (List<Favorito>) favoritoRepository.findAll();
    }

    @Override
    public void quitarFavoritos(Integer idFavorito) {
        favoritoRepository.deleteById(idFavorito);
    }

}
