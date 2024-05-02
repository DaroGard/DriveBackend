package unah.edu.hn.bases1.proyecto.Controllers;

import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Grupo;
import unah.edu.hn.bases1.proyecto.services.imp.GrupoServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("drive/grupos")

public class GrupoController {
    
    @Autowired
    private GrupoServiceImp grupoServiceImp;

    @PostMapping("/crearGrupo")
    public Grupo crearGrupo(@RequestBody Grupo grupo) {        
        return this.grupoServiceImp.crearGrupo(grupo);
    }

    @GetMapping("/obtenerGrupos")
    public List<Grupo> obtenerGrupos() {
        return this.grupoServiceImp.obtenerGrupos();
    }

    @PutMapping("/modificarGrupo/{id_grupo}")
    public Grupo modificarGrupo(@PathVariable int id_grupo, @RequestBody Grupo grupo) {
        return this.grupoServiceImp.modificarGrupo(id_grupo, grupo);
    }
    
    @DeleteMapping("/eliminarGrupo/{id_grupo}")
    public String eliminarGrupo(@PathVariable int id_grupo) {
        return this.grupoServiceImp.eliminarGrupo(id_grupo);
    }
}
