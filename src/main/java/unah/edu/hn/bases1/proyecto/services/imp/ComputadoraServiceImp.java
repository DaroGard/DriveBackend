package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Computadora;
import unah.edu.hn.bases1.proyecto.Entities.Usuario;
import unah.edu.hn.bases1.proyecto.repository.ComputadoraRepository;
import unah.edu.hn.bases1.proyecto.services.ComputadoraService;

@Service
public class ComputadoraServiceImp implements ComputadoraService {

    @Autowired
    private ComputadoraRepository computadoraRepository;

    @Override
    public Computadora crearComputadora(Computadora computadora) {
        if (computadora == null || computadora.getUsuario() == null) {
            return null;
        }

        Usuario usuario = computadora.getUsuario();
        if (usuario == null) {
            return null;
        }

        computadora.setUsuario(usuario);

        return this.computadoraRepository.save(computadora);
    }

    @Override
    public List<Computadora> obtenerComputadoras() {
        return (List<Computadora>) this.computadoraRepository.findAll();
    }

    @Override
    public String eliminarComputadora(Integer id_computadora) {
        if (this.computadoraRepository.existsById(id_computadora)) {
            Computadora computadoraEliminar = this.computadoraRepository.findById(id_computadora).get();
            this.computadoraRepository.delete(computadoraEliminar);
            return "Computadora eliminada con exito";
        } else {
            return "La computadora con id: " + id_computadora + " no existe";
        }
    }

}
