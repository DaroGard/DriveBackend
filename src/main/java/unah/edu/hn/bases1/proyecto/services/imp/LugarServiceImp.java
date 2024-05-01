package unah.edu.hn.bases1.proyecto.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Lugar;
import unah.edu.hn.bases1.proyecto.repository.LugarRepository;
import unah.edu.hn.bases1.proyecto.services.LugarService;

@Service
public class LugarServiceImp implements LugarService {

    @Autowired
    private LugarRepository lugarRepository;

    @Override
    public Iterable<Lugar> obtenerLugares() {
        return lugarRepository.findAll();
    }

}
