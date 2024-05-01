package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.TipoArchivo;
import unah.edu.hn.bases1.proyecto.repository.TipoArchivoRepository;
import unah.edu.hn.bases1.proyecto.services.TipoArchivoService;

@Service
public class TiposArchivoServiceImp implements TipoArchivoService {

    @Autowired
    TipoArchivoRepository tipoArchivoRepository;

    @Override
    public List<TipoArchivo> obtenerTipos() {
        return (List<TipoArchivo>) this.tipoArchivoRepository.findAll();
    }

}
