package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_versiones_archivos")
@NoArgsConstructor
@AllArgsConstructor
public class VersionArchivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_version")
    private Long idVersion;

    @Column(name = "id_archivo", nullable = false)
    private Long idArchivo;

    @Column(name = "nombre_archivo", nullable = false, length = 100)
    private String nombreArchivo;

    @Column(name = "ruta_archivo", nullable = false, length = 200)
    private String rutaArchivo;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "id_usuario_creador", nullable = false)
    private Long idUsuarioCreador;
}