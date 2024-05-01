package unah.edu.hn.bases1.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Lugar;
import unah.edu.hn.bases1.proyecto.services.imp.LugarServiceImp;

@RestController
@RequestMapping("drive/lugares")
public class LugarController {

    @Autowired
    private LugarServiceImp lugarServiceImp;

    @GetMapping("/todos")
    public ResponseEntity<Iterable<Lugar>> obtenerLugares() {
        Iterable<Lugar> lugares = lugarServiceImp.obtenerLugares();
        return ResponseEntity.ok(lugares);
    }

}
