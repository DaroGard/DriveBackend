package unah.edu.hn.bases1.proyecto.services;

import unah.edu.hn.bases1.proyecto.Entities.Computadora;
import java.util.List;

public interface ComputadoraService {
    
    public Computadora crearComputadora(Computadora computadora);

    public List<Computadora> obtenerComputadoras();

    public String eliminarComputadora(Integer id_computadora);
}
