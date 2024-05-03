package unah.edu.hn.bases1.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.bases1.proyecto.Entities.Archivo;
import unah.edu.hn.bases1.proyecto.Entities.Usuario;
import unah.edu.hn.bases1.proyecto.services.imp.ArchivoServiceImp;
import unah.edu.hn.bases1.proyecto.services.imp.UsuarioServiceImp;

@RestController
@RequestMapping("drive/archivos")
public class ArchivoController {

    @Autowired
    private ArchivoServiceImp archivoServiceImp;

    @Autowired
    private UsuarioServiceImp usuarioServiceImp;

    @PostMapping("/guardar")
    public ResponseEntity<Archivo> guardarArchivo(@RequestBody Archivo archivo) {
        Archivo archivoGuardado = archivoServiceImp.guardarArchivo(archivo);
        return new ResponseEntity<>(archivoGuardado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Archivo> obtenerArchivoPorId(@PathVariable("id") Integer id) {
        Archivo archivo = archivoServiceImp.obtenerArchivoPorId(id);
        if (archivo != null) {
            return new ResponseEntity<>(archivo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Archivo>> obtenerArchivosPorUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        Usuario usuario = usuarioServiceImp.obtenerUsuarioPorId(idUsuario);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        List<Archivo> archivos = archivoServiceImp.obtenerArchivosPorUsuario(usuario);
        return ResponseEntity.ok().body(archivos);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> borrarArchivo(@PathVariable("id") Integer idArchivo) {
        archivoServiceImp.borrarArchivo(idArchivo);
        return new ResponseEntity<>("Archivo borrado correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public Archivo actualizarArchivo(@PathVariable Integer id, @RequestBody Archivo archivo) {
        archivo.setIdArchivo(id);
        return archivoServiceImp.actualizarArchivo(archivo);
    }

    @GetMapping("/porTipo/{idTipoArchivo}")
    public ResponseEntity<List<Archivo>> obtenerArchivosPorTipo(@PathVariable Integer idTipoArchivo) {
        List<Archivo> archivos = archivoServiceImp.obtenerArchivosPorTipo(idTipoArchivo);
        return ResponseEntity.ok(archivos);
    }

}