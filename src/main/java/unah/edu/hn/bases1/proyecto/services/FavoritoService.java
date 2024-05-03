package unah.edu.hn.bases1.proyecto.services;

import java.util.List;

import unah.edu.hn.bases1.proyecto.Entities.Favorito;

public interface FavoritoService {

    public Favorito agregarFavorito(Favorito Favorito);

    public List<Favorito> obtenerFavoritos();

    public void quitarFavoritos(Integer idFavorito);

}
