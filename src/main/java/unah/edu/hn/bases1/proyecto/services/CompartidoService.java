package unah.edu.hn.bases1.proyecto.services;

import unah.edu.hn.bases1.proyecto.Entities.Compartido;
import java.util.List;


public interface CompartidoService {
    
    public Compartido crearCompartido(Compartido compartido);

    public List<Compartido> obtenerCompartidos();

    public Compartido obtenerCompartidoPorId(Integer id_compartido);

    public Compartido modificarCompartido(Integer id_compartido, Compartido compartido);

    public String eliminarCompartido(Integer id_compartido);
}
