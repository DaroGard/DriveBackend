package unah.edu.hn.bases1.proyecto.services;

import java.util.Date;
import java.util.List;

import unah.edu.hn.bases1.proyecto.Entities.Archivo;
import unah.edu.hn.bases1.proyecto.dtos.Carpeta;

public interface ArchivoService {

    public List<Archivo> obtenerTodosLosArchivos(int idPropietario);

    public List<Archivo> obtenerCarpetas(int idPropietario);

    public List<Archivo> obtenerArchivosPorTipo(int idPropietario, int tipo);

    public List<Archivo> obtenerArchivosPorPersonaPropietario(int idPropietario, int idPersona);

    public List<Archivo> obtenerArchivosporFecha(int idPropietario, Date Fecha);

    public List<Archivo> obtenerArchivosporEstado(int idPropietario, int idEstado);

    public List<Archivo> obtenerArchivosporNombre(int idPropietario, String Nombre);

    public List<Archivo> obtenerCarpetasporPersona(int idPropietario);

    public Archivo obtenerArchivo(int idArchivo);

    public Archivo crearArchivo(Archivo archivo);

    public Archivo crearCarpeta(Carpeta carpeta);

    List<Archivo> obtenerArchivosPorNombre(String nombre);

    public List<Archivo> obtenertodos();

}
