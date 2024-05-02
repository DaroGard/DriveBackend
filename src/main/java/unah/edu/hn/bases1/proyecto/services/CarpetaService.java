package unah.edu.hn.bases1.proyecto.services;

import java.util.List;

import unah.edu.hn.bases1.proyecto.Entities.Carpeta;
import unah.edu.hn.bases1.proyecto.Entities.EstadoCarpeta;

public interface CarpetaService {

    public Carpeta guardarCarpeta(Carpeta carpeta);

    public Carpeta actualizarCarpeta(Carpeta carpeta);

    public void eliminarCarpeta(Integer idCarpeta);

    public Carpeta obtenerCarpetaPorId(Integer idCarpeta);

    public List<Carpeta> obtenerTodasLasCarpetas();

    public List<Carpeta> obtenerCarpetasPorEstado(EstadoCarpeta estadoCarpeta);

    public List<Carpeta> obtenerCarpetasHijas(Integer idCarpetaPadre);

}