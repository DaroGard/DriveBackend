package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import unah.edu.hn.bases1.proyecto.Entities.Archivo;
import unah.edu.hn.bases1.proyecto.Entities.Carpeta;
import unah.edu.hn.bases1.proyecto.Entities.EstadoCarpeta;
import unah.edu.hn.bases1.proyecto.repository.ArchivoRepository;
import unah.edu.hn.bases1.proyecto.repository.CarpetaRepository;
import unah.edu.hn.bases1.proyecto.services.CarpetaService;

@Service
public class CarpetaServiceImp implements CarpetaService {

    @Autowired
    private CarpetaRepository carpetaRepository;

    @Autowired
    private ArchivoRepository archivoRepository;

    @Override
    public Carpeta guardarCarpeta(Carpeta carpeta) {
        Carpeta carpetaExistente = carpetaRepository.findByNombreCarpeta(carpeta.getNombreCarpeta());
        if (carpetaExistente != null) {
            throw new DataIntegrityViolationException("Ya existe una carpeta con el mismo nombre");
        }

        EstadoCarpeta estadoPorDefecto = new EstadoCarpeta();
        estadoPorDefecto.setIdEstado(1);
        carpeta.setEstadoCarpeta(estadoPorDefecto);

        return carpetaRepository.save(carpeta);
    }

    @Override
    public Carpeta actualizarCarpeta(Carpeta carpeta) {

        Carpeta carpetaExistente = carpetaRepository.findByNombreCarpeta(carpeta.getNombreCarpeta());
        if (carpetaExistente != null && !carpetaExistente.getIdCarpeta().equals(carpeta.getIdCarpeta())) {
            throw new DataIntegrityViolationException("Ya existe una carpeta con el mismo nombre");
        }

        if (carpeta.getCarpetaPadre() != null
                && carpeta.getCarpetaPadre().getIdCarpeta().equals(carpeta.getIdCarpeta())) {
            throw new DataIntegrityViolationException("Una carpeta no puede ser su propio padre");
        }

        if (carpeta.getCarpetaPadre() != null) {
            Carpeta carpetaPadreExistente = carpetaRepository.findById(carpeta.getCarpetaPadre().getIdCarpeta())
                    .orElse(null);
            if (carpetaPadreExistente == null) {
                throw new DataIntegrityViolationException("La carpeta padre no existe");
            }
        }

        if (carpeta.getArchivos() != null && !carpeta.getArchivos().isEmpty()) {
            for (Archivo archivo : carpeta.getArchivos()) {
                Archivo archivoExistente = archivoRepository.findById(archivo.getIdArchivo()).orElse(null);
                if (archivoExistente == null) {
                    throw new DataIntegrityViolationException("El archivo a vincular no existe");
                }
                if (archivoExistente.getCarpeta() != null && !archivoExistente.getCarpeta().equals(carpeta)) {
                    throw new DataIntegrityViolationException("El archivo ya está vinculado a otra carpeta");
                }

                archivoExistente.setCarpeta(carpeta);
            }
        }

        return carpetaRepository.save(carpeta);
    }

    @Override
    @Transactional
    public void eliminarCarpeta(Integer idCarpeta) {
        Carpeta carpeta = carpetaRepository.findById(idCarpeta).orElse(null);
        if (carpeta != null) {
            eliminarRecursivoCarpetasHijas(carpeta);
            carpetaRepository.deleteById(idCarpeta);
        }
    }

    private void eliminarRecursivoCarpetasHijas(Carpeta carpeta) {
        List<Carpeta> carpetasHijas = carpetaRepository.findCarpetasHijasByIdCarpeta(carpeta.getIdCarpeta());
        for (Carpeta hija : carpetasHijas) {
            eliminarRecursivoCarpetasHijas(hija);
            carpetaRepository.deleteById(hija.getIdCarpeta());
        }
    }

    @Override
    public Carpeta obtenerCarpetaPorId(Integer idCarpeta) {
        return carpetaRepository.findById(idCarpeta).orElse(null);
    }

    @Override
    public List<Carpeta> obtenerTodasLasCarpetas() {
        return (List<Carpeta>) carpetaRepository.findAll();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Carpeta> obtenerCarpetasPorEstado(EstadoCarpeta estadoCarpeta) {
        return (List<Carpeta>) carpetaRepository.findByEstadoCarpeta(estadoCarpeta);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Carpeta> obtenerCarpetasHijas(Integer idCarpetaPadre) {
        return (List<Carpeta>) carpetaRepository.findByCarpetaPadreIdCarpeta(idCarpetaPadre);
    }

}
