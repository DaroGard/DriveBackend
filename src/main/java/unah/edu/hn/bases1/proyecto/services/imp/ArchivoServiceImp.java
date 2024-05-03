package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Archivo;
import unah.edu.hn.bases1.proyecto.Entities.EstadoArchivo;
import unah.edu.hn.bases1.proyecto.Entities.TipoArchivo;
import unah.edu.hn.bases1.proyecto.Entities.Usuario;
import unah.edu.hn.bases1.proyecto.repository.ArchivoRepository;
import unah.edu.hn.bases1.proyecto.repository.EstadoArchivoRepository;
import unah.edu.hn.bases1.proyecto.repository.FavoritoRepository;
import unah.edu.hn.bases1.proyecto.repository.TipoArchivoRepository;
import unah.edu.hn.bases1.proyecto.services.ArchivoService;

@Service
public class ArchivoServiceImp implements ArchivoService {

    @Autowired
    private ArchivoRepository archivoRepository;

    @Autowired
    private TipoArchivoRepository tipoArchivoRepository;

    @Autowired
    private EstadoArchivoRepository estadoArchivoRepository;

    @Autowired
    private FavoritoRepository favoritoRepository;

    @Override
    public Archivo guardarArchivo(Archivo archivo) {
        archivo.setFechaCreacion(new Date());

        String nombreArchivo = archivo.getNombre();
        Archivo archivoExistente = archivoRepository.findByNombre(nombreArchivo);
        if (archivoExistente != null) {
            throw new IllegalArgumentException("Ya existe un archivo con el nombre: " + nombreArchivo);
        }

        if (archivo.getTipoArchivo() == null || archivo.getTipoArchivo().getIdTipoArchivo() == null) {
            throw new IllegalArgumentException("Tipo de archivo no proporcionado");
        }

        TipoArchivo tipoArchivoProporcionado = tipoArchivoRepository
                .findById(archivo.getTipoArchivo().getIdTipoArchivo())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de archivo proporcionado no encontrado"));

        archivo.setTipoArchivo(tipoArchivoProporcionado);

        EstadoArchivo estadoArchivoPorDefecto = estadoArchivoRepository.findById(1)
                .orElseThrow(() -> new IllegalStateException("Estado de archivo por defecto no encontrado"));

        archivo.setEstadoArchivo(estadoArchivoPorDefecto);

        archivo.setFechaUtilizacion(new Date());

        Usuario usuario = archivo.getUsuario();
        if (usuario != null) {
            usuario.getArchivos().add(archivo);
            archivo.setUsuario(usuario);
        } else {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        return archivoRepository.save(archivo);
    }

    @Override
    public Archivo obtenerArchivoPorId(Integer id) {
        return archivoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Archivo> obtenerArchivosPorUsuario(Usuario usuario) {
        return archivoRepository.findByUsuario(usuario);
    }

    @Override
    public void borrarArchivo(Integer idArchivo) {
        Optional<Archivo> archivoOptional = archivoRepository.findById(idArchivo);
        if (archivoOptional.isPresent()) {
            Archivo archivo = archivoOptional.get();

            favoritoRepository.deleteByArchivo(archivo);

            Usuario usuario = archivo.getUsuario();
            if (usuario != null) {
                usuario.getArchivos().remove(archivo);
            }

            TipoArchivo tipoArchivo = archivo.getTipoArchivo();
            if (tipoArchivo != null) {
                tipoArchivo.getArchivos().remove(archivo);
            }

            EstadoArchivo estadoArchivo = archivo.getEstadoArchivo();
            if (estadoArchivo != null) {
                estadoArchivo.getArchivos().remove(archivo);
            }

            archivoRepository.delete(archivo);
        } else {
            throw new IllegalArgumentException("Archivo no encontrado con ID: " + idArchivo);
        }
    }

    @Override
    public Archivo actualizarArchivo(Archivo archivo) {
        Archivo archivoExistente = archivoRepository.findById(archivo.getIdArchivo()).orElse(null);

        if (archivoExistente != null) {
            if (archivo.getNombre() != null) {
                archivoExistente.setNombre(archivo.getNombre());
            }

            if (archivo.getDescripcion() != null) {
                archivoExistente.setDescripcion(archivo.getDescripcion());
            }

            archivoExistente.setFechaUtilizacion(new Date());

            if (archivo.getUsuario() != null) {
                archivoExistente.setUsuario(archivo.getUsuario());
            }

            if (archivo.getTipoArchivo() != null) {
                archivoExistente.setTipoArchivo(archivo.getTipoArchivo());
            }

            if (archivo.getEstadoArchivo() != null) {
                archivoExistente.setEstadoArchivo(archivo.getEstadoArchivo());
            }

            if (archivo.getCarpeta() != null) {
                archivoExistente.setCarpeta(archivo.getCarpeta());
            }

            if (archivo.getTamano() != null) {
                archivoExistente.setTamano(archivo.getTamano());
            }

            return archivoRepository.save(archivoExistente);
        } else {
            throw new IllegalArgumentException("El archivo con ID " + archivo.getIdArchivo() + " no existe");
        }
    }

    @Override
    public List<Archivo> obtenerArchivosPorTipo(Integer idTipoArchivo) {
        return archivoRepository.findArchivosByTipoArchivoId(idTipoArchivo);
    }

}