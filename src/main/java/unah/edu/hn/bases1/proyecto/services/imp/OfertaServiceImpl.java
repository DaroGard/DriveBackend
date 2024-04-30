package unah.edu.hn.bases1.proyecto.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Oferta;
import unah.edu.hn.bases1.proyecto.repository.OfertaRepository;
import unah.edu.hn.bases1.proyecto.services.OfertaService;

@Service
public class OfertaServiceImpl implements OfertaService {
    @Autowired
    private OfertaRepository ofertaRepository;

    @Override
    public Oferta crearOferta(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

}
