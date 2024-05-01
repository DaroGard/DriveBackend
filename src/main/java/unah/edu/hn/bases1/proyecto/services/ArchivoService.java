package unah.edu.hn.bases1.proyecto.services;

import java.util.List;

import unah.edu.hn.bases1.proyecto.Entities.Archivo;
import unah.edu.hn.bases1.proyecto.Entities.Usuario;

public interface ArchivoService {

    public Archivo guardarArchivo(Archivo archivo);

    public Archivo obtenerArchivoPorId(Integer id);

    public List<Archivo> obtenerArchivosPorUsuario(Usuario usuario);

    public void borrarArchivo(Integer idArchivo);

    public Archivo actualizarArchivo(Archivo archivo);

}