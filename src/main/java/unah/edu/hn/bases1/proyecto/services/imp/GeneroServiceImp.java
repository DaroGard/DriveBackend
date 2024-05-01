package unah.edu.hn.bases1.proyecto.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Genero;
import unah.edu.hn.bases1.proyecto.repository.GeneroRepository;
import unah.edu.hn.bases1.proyecto.services.GeneroService;

@Service
public class GeneroServiceImp implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public Iterable<Genero> obtenerGeneros() {
        return generoRepository.findAll();
    }

}
