package unah.edu.hn.bases1.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Computadora;
import unah.edu.hn.bases1.proyecto.services.imp.ComputadoraServiceImp;

@RestController
@RequestMapping("drive/computadoras")

public class ComputadoraController {

    @Autowired
    private ComputadoraServiceImp computadoraServiceImp;

    @PostMapping("/crear")
    public Computadora crearComputadora(@RequestBody Computadora computadora) {
        return this.computadoraServiceImp.crearComputadora(computadora);
    }

    @GetMapping("/todas")
    public List<Computadora> obtenerComputadoras() {
        return this.computadoraServiceImp.obtenerComputadoras();
    }

    @DeleteMapping("/eliminarComputadora/{id_computadora}")
    public String eliminarComputadora(@PathVariable Integer id_computadora) {
        return this.computadoraServiceImp.eliminarComputadora(id_computadora);
    }

}
