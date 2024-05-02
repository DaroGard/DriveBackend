package unah.edu.hn.bases1.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Carpeta;
import unah.edu.hn.bases1.proyecto.Entities.EstadoCarpeta;
import unah.edu.hn.bases1.proyecto.services.imp.CarpetaServiceImp;

@RestController
@RequestMapping("/drive/carpetas")
public class CarpetaController {

    @Autowired
    private CarpetaServiceImp carpetaServiceImp;

    @PostMapping("/guardar")
    public Carpeta guardarCarpeta(@RequestBody Carpeta carpeta) {
        return carpetaServiceImp.guardarCarpeta(carpeta);
    }

    @PutMapping("/actualizar")
    public Carpeta actualizarCarpeta(@RequestBody Carpeta carpeta) {
        return carpetaServiceImp.actualizarCarpeta(carpeta);
    }

    @DeleteMapping("/eliminar/{idCarpeta}")
    public void eliminarCarpeta(@PathVariable Integer idCarpeta) {
        carpetaServiceImp.eliminarCarpeta(idCarpeta);
    }

    @GetMapping("/{idCarpeta}")
    public Carpeta obtenerCarpetaPorId(@PathVariable Integer idCarpeta) {
        return carpetaServiceImp.obtenerCarpetaPorId(idCarpeta);
    }

    @GetMapping("/todas")
    public List<Carpeta> obtenerTodasLasCarpetas() {
        return carpetaServiceImp.obtenerTodasLasCarpetas();
    }

    @GetMapping("/porEstado/{idEstado}")
    public List<Carpeta> obtenerCarpetasPorEstado(@PathVariable Integer idEstado) {
        EstadoCarpeta estadoCarpeta = new EstadoCarpeta();
        estadoCarpeta.setIdEstado(idEstado);
        return carpetaServiceImp.obtenerCarpetasPorEstado(estadoCarpeta);
    }

    @GetMapping("/hijas/{idCarpetaPadre}")
    public List<Carpeta> obtenerCarpetasHijas(@PathVariable Integer idCarpetaPadre) {
        return carpetaServiceImp.obtenerCarpetasHijas(idCarpetaPadre);
    }

}
