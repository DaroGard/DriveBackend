package unah.edu.hn.bases1.proyecto.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.bases1.proyecto.Entities.Compartido;
import unah.edu.hn.bases1.proyecto.repository.ArchivoRepository;
import unah.edu.hn.bases1.proyecto.repository.CompartidoRepository;
import unah.edu.hn.bases1.proyecto.repository.PermisoRepository;
import unah.edu.hn.bases1.proyecto.repository.UsuarioRepository;
import unah.edu.hn.bases1.proyecto.services.CompartidoService;

@Service
public class CompartidoServiceImp implements CompartidoService{

    @Autowired
    private CompartidoRepository compartidoRepository;

    @Autowired
    private ArchivoRepository archivoRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Compartido crearCompartido(Compartido compartido) {
        int id_compartido = compartido.getIdCompartido();
        if (this.compartidoRepository.existsById(id_compartido)) {
            return null;
        }else{
            int id_archivo = compartido.getArchivo().getIdArchivo();
            int id_permiso = compartido.getPermiso().getIdPermiso();
            int id_usuario_compartido = compartido.getUsuarioCompartido().getIdUsuario();
            int id_usuario_propietario = compartido.getUsuarioPropietario().getIdUsuario();
            
            if (this.archivoRepository.existsById(id_archivo)) {
                if (this.permisoRepository.existsById(id_permiso)) {
                    if (this.usuarioRepository.existsById(id_usuario_compartido)) {
                        if (this.usuarioRepository.existsById(id_usuario_propietario)) {
                            compartido.setArchivo(this.archivoRepository.findById(id_archivo).get());
                            compartido.setPermiso(this.permisoRepository.findById(id_permiso).get());
                            compartido.setUsuarioCompartido(this.usuarioRepository.findById(id_usuario_compartido).get());
                            compartido.setUsuarioPropietario(this.usuarioRepository.findById(id_usuario_propietario).get());

                            return this.compartidoRepository.save(compartido);
                        }
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
    }

    @Override
    public List<Compartido> obtenerCompartidos() {
        return (List<Compartido>) this.compartidoRepository.findAll();
    }

    @Override
    public Compartido modificarCompartido(Integer id_compartido, Compartido compartido) {
        if (this.compartidoRepository.existsById(id_compartido)) {
            Compartido compartidoModificar = this.compartidoRepository.findById(id_compartido).get();
            compartidoModificar.setFechaCompartido(compartido.getFechaCompartido());
            compartidoModificar.setUltimaModificacion(compartido.getUltimaModificacion());
            compartidoModificar.setArchivo(compartido.getArchivo());
            compartidoModificar.setPermiso(compartido.getPermiso());
            compartidoModificar.setUsuarioCompartido(compartido.getUsuarioCompartido());
            compartidoModificar.setUsuarioPropietario(compartido.getUsuarioPropietario());

            return this.compartidoRepository.save(compartidoModificar);
        }
        return null;
    }

    @Override
    public String eliminarCompartido(Integer id_compartido) {
        if (this.compartidoRepository.existsById(id_compartido)) {
            Compartido compartidoEliminar = this.compartidoRepository.findById(id_compartido).get();
            this.compartidoRepository.delete(compartidoEliminar);
            return "Compartido eliminado con exito";
        }
        return "No existe el compartido con id:" + id_compartido;
    }

    @Override
    public Compartido obtenerCompartidoPorId(Integer id_compartido) {
        if (this.compartidoRepository.existsById(id_compartido)) {
            return this.compartidoRepository.findById(id_compartido).get();
        }
        return null;
    }
    
}
