package unah.edu.hn.bases1.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.TipoArchivo;
import unah.edu.hn.bases1.proyecto.services.imp.TiposArchivoServiceImp;

@RestController
@RequestMapping("drive/tiposarchivo")
public class TipoArchivoController {

    @Autowired
    private TiposArchivoServiceImp tiposArchivoServiceImp;

    @GetMapping("/todos")
    public List<TipoArchivo> obtenerTodosTipos() {
        return (List<TipoArchivo>) tiposArchivoServiceImp.obtenerTipos();
    }

}
