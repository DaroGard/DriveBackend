package unah.edu.hn.bases1.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Preferencia;
import unah.edu.hn.bases1.proyecto.services.imp.PreferenciaServiceImp;

@RestController
@RequestMapping("drive/usuarios/preferencia")
public class PreferenciaController {

    @Autowired
    private PreferenciaServiceImp preferenciaServiceImp;

    @GetMapping("/todas")
    public ResponseEntity<Iterable<Preferencia>> obtenerpreferencias() {
        Iterable<Preferencia> preferencias = preferenciaServiceImp.obtenerPreferencias();
        return ResponseEntity.ok(preferencias);
    }

}
