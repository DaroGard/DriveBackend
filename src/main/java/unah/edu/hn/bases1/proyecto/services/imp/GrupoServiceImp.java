package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Grupo;
import unah.edu.hn.bases1.proyecto.repository.GrupoRepository;
import unah.edu.hn.bases1.proyecto.services.GrupoService;

@Service
public class GrupoServiceImp implements GrupoService{

    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public Grupo crearGrupo(Grupo grupo) {
        Integer id_grupo = grupo.getIdGrupo();
        if (this.grupoRepository.existsById(id_grupo)) {
            return this.grupoRepository.findById(id_grupo).get();
        }else{
            return this.grupoRepository.save(grupo);
        }
    }

    @Override
    public List<Grupo> obtenerGrupos() {
        return (List<Grupo>) this.grupoRepository.findAll();
    }

    @Override
    public Grupo modificarGrupo(int id_grupo, Grupo grupo) {
        if (this.grupoRepository.existsById(id_grupo)) {
           if (null!=grupo) {
            Grupo grupoModificar = this.grupoRepository.findById(id_grupo).get();
            grupoModificar.setDescripcion(grupo.getDescripcion());
            grupoModificar.setFechaCreacion(grupo.getFechaCreacion());
            grupoModificar.setNombreGrupo(grupo.getNombreGrupo());
            return this.grupoRepository.save(grupoModificar);
           }
           return null;
        }
        return null;
    }

    @Override
    public String eliminarGrupo(int id_grupo) {
        if (this.grupoRepository.existsById(id_grupo)) {
            Grupo grupo = this.grupoRepository.findById(id_grupo).get();
            this.grupoRepository.delete(grupo);
            return "Grupo Eliminado con exito.";
        }else{
            return "El grupo con id:" + id_grupo + " no existe.";
        }
    }
}
