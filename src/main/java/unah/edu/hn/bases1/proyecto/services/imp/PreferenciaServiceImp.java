package unah.edu.hn.bases1.proyecto.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Preferencia;
import unah.edu.hn.bases1.proyecto.repository.PreferenciaRepository;
import unah.edu.hn.bases1.proyecto.services.PreferenciaService;

@Service
public class PreferenciaServiceImp implements PreferenciaService {

    @Autowired
    private PreferenciaRepository preferenciaRepository;

    @Override
    public Iterable<Preferencia> obtenerPreferencias() {
        return preferenciaRepository.findAll();
    }

}
