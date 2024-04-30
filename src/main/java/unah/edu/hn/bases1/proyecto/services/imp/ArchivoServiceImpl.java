package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Archivo;
import unah.edu.hn.bases1.proyecto.Entities.Compartido;
import unah.edu.hn.bases1.proyecto.dtos.Carpeta;
import unah.edu.hn.bases1.proyecto.repository.ArchivoRepository;
import unah.edu.hn.bases1.proyecto.repository.CompartidoRepository;
import unah.edu.hn.bases1.proyecto.repository.EstadoArchivoRepositoy;
import unah.edu.hn.bases1.proyecto.repository.TipoArchivoRepository;
import unah.edu.hn.bases1.proyecto.repository.UsuarioRepository;
import unah.edu.hn.bases1.proyecto.services.ArchivoService;

@Service
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    ArchivoRepository archivoRepository;
    @Autowired
    CompartidoRepository compartidoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TipoArchivoRepository tipoArchivoRepository;
    @Autowired
    EstadoArchivoRepositoy estadoArchivoRepositoy;

    @Override
    public List<Archivo> obtenerTodosLosArchivos(int idPropietario) {
        List<Archivo> listaArchivos = this.archivoRepository.findByPropietario_IdUsuario(idPropietario);
        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerCarpetas(int idPropietario) {
        // el id tiene que ser el que corresponda con carpetas
        List<Archivo> listaCarpetas = this.archivoRepository
                .findByTipoArchivo_IdTipoArchivoAndPropietario_IdUsuario(idPropietario, 1);
        return listaCarpetas;
    }

    @Override
    public List<Archivo> obtenerArchivosPorTipo(int idPropietario, int tipo) {
        List<Archivo> listaArchivos = this.archivoRepository
                .findByTipoArchivo_IdTipoArchivoAndPropietario_IdUsuario(idPropietario, tipo);
        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerArchivosPorPersonaPropietario(int idPropietario, int idPersona) {
        List<Compartido> listaCompartidos = this.compartidoRepository
                .findByPropietario_IdUsuarioAndUsuarioreceptor_IdUsuario(idPropietario, idPersona);
        List<Archivo> listaArchivos = new LinkedList<Archivo>();
        for (Compartido compartido : listaCompartidos) {
            listaArchivos.add(compartido.getArchivo());
        }

        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerArchivosporFecha(int idPropietario, Date Fecha) {
        List<Archivo> listaArchivos = this.archivoRepository.findByFechaCreacionAndPropietario_IdUsuario(Fecha,
                idPropietario);
        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerArchivosporEstado(int idPropietario, int idEstado) {
        List<Archivo> listaArchivos = this.archivoRepository
                .findByEstadoArchivo_IdEstadoAndPropietario_IdUsuario(idEstado, idPropietario);
        return listaArchivos;
    }

    @Override
    public List<Archivo> obtenerArchivosporNombre(int idPropietario, String Nombre) {
        List<Archivo> lista = this.archivoRepository.findAll();
        // List<Archivo> lista2 = new LinkedList<Archivo>();
        // for (Archivo archivo : lista) {
        // if (archivo.getNombre() == Nombre && archivo.getPropietario().getIdUsuario()
        // == idPropietario) {
        // lista2.add(archivo);
        // }
        // }
        return this.archivoRepository.findAll();

    }

    @Override
    public List<Archivo> obtenerCarpetasporPersona(int idPropietario) {
        List<Archivo> listaArchivos = this.archivoRepository
                .findByTipoArchivo_IdTipoArchivoAndPropietario_IdUsuario(idPropietario, idPropietario);
        return listaArchivos;
    }

    @Override
    public Archivo obtenerArchivo(int idArchivo) {
        Archivo archivo = this.archivoRepository.findById(idArchivo).get();
        return archivo;
    }

    @Override
    public Archivo crearArchivo(Archivo archivo) {
        return archivoRepository.save(archivo);
    }

    @Override
    public Archivo crearCarpeta(Carpeta carpeta) {
        Archivo nvoCarpeta = new Archivo();
        nvoCarpeta.setTamano(0);
        nvoCarpeta.setNombre(carpeta.getNombre());
        nvoCarpeta.setUsuario(this.usuarioRepository.findById(carpeta.getPropietaro()).get());
        nvoCarpeta.setFechaCreacion(carpeta.getFechaCreacion());
        nvoCarpeta.setFechaAbierto(carpeta.getFechaCreacion());
        nvoCarpeta.setDescripcion("");
        nvoCarpeta.setTipoArchivo(this.tipoArchivoRepository.findById(1).get()); // poner el id que corresponda a la
                                                                                 // carpetas
        this.archivoRepository.save(nvoCarpeta);
        return nvoCarpeta;
    }

    public ArchivoServiceImpl(ArchivoRepository archivoRepository) {
        this.archivoRepository = archivoRepository;
    }

    @Override
    public List<Archivo> obtenerArchivosPorNombre(String nombre) {
        return archivoRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Archivo> obtenertodos() {
        return this.archivoRepository.findAll();
    }

}
