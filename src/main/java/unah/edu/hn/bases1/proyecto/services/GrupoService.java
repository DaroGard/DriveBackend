package unah.edu.hn.bases1.proyecto.services;

import unah.edu.hn.bases1.proyecto.Entities.Grupo;
import java.util.List;

public interface GrupoService {
    
    public Grupo crearGrupo(Grupo grupo);

    public List<Grupo> obtenerGrupos();

    public Grupo modificarGrupo(int id_grupo, Grupo grupo);

    public String eliminarGrupo(int id_grupo);
}
