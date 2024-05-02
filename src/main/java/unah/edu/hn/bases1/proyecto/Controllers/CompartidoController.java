package unah.edu.hn.bases1.proyecto.Controllers;

import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Compartido;
import unah.edu.hn.bases1.proyecto.services.imp.CompartidoServiceImp;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("drive/compartidos")

public class CompartidoController {
    
    @Autowired
    private CompartidoServiceImp compartidoServiceImp;

    @PostMapping("/crearCompartido")
    public Compartido crearCompartido(@RequestBody Compartido compartido) {
        return this.compartidoServiceImp.crearCompartido(compartido);
    }

    @GetMapping("/obtenerCompartidos")
    public List<Compartido> obtenerCompartidos() {
        return this.compartidoServiceImp.obtenerCompartidos();
    }

    @GetMapping("/obtenerCompartidoPorId/{id_compartido}")
    public Compartido obtenerCompartidoPorId(@PathVariable Integer id_compartido) {
        return this.compartidoServiceImp.obtenerCompartidoPorId(id_compartido);
    }
    
    @PutMapping("/modificarCompartido/{id_compartido}")
    public Compartido modificarCompartido(@PathVariable Integer id_compartido, @RequestBody Compartido compartido) {
        return this.compartidoServiceImp.modificarCompartido(id_compartido, compartido);
    }
    
    @DeleteMapping("/eliminarCompartido/{id_compartido}")
    public String eliminarCompartido(@PathVariable Integer id_compartido) {
        return this.compartidoServiceImp.eliminarCompartido(id_compartido);
    }
    
}
