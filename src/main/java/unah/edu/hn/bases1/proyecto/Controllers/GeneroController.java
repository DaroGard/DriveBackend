package unah.edu.hn.bases1.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Genero;
import unah.edu.hn.bases1.proyecto.services.imp.GeneroServiceImpl;

@RestController
@RequestMapping("/api/genero")
public class GeneroController {

    @Autowired
    private GeneroServiceImpl generoServiceImpl;

    @PostMapping("/crear")
    public Genero crearGenero(@RequestBody Genero nvoGenero) {
        return this.generoServiceImpl.crearGenero(nvoGenero);
    }

}
