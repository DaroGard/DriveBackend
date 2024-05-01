package unah.edu.hn.bases1.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Genero;
import unah.edu.hn.bases1.proyecto.services.imp.GeneroServiceImp;

@RestController
@RequestMapping("drive/usuario/genero")

public class GeneroController {

    @Autowired
    private GeneroServiceImp generoServiceImp;

    @GetMapping("/todos")
    public ResponseEntity<Iterable<Genero>> obtenerGeneros() {
        Iterable<Genero> generos = generoServiceImp.obtenerGeneros();
        return ResponseEntity.ok(generos);
    }

}
