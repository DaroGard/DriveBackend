package unah.edu.hn.bases1.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Favorito;
import unah.edu.hn.bases1.proyecto.services.imp.FavoritoServiceImp;

@RestController
@RequestMapping("/drive/archivos/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoServiceImp favoritoServiceImp;

    @PostMapping("/agregar")
    public ResponseEntity<Favorito> agregarFavorito(@RequestBody Favorito favorito) {
        try {
            Favorito nuevoFavorito = favoritoServiceImp.agregarFavorito(favorito);
            return new ResponseEntity<>(nuevoFavorito, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Favorito>> obtenerFavoritos() {
        List<Favorito> favoritos = favoritoServiceImp.obtenerFavoritos();
        return new ResponseEntity<>(favoritos, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> quitarFavorito(@PathVariable Integer id) {
        try {
            favoritoServiceImp.quitarFavoritos(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
