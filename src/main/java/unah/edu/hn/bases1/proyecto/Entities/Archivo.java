package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_archivos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Archivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_archivo")
    private Integer idArchivo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_archivo", nullable = false)
    private TipoArchivo tipoArchivo;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadoArchivo estadoArchivo;

    @ManyToOne
    @JoinColumn(name = "id_carpeta")
    private Carpeta carpeta;

    @Column(name = "tamano", nullable = false)
    private Integer tamano;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_utilizacion", nullable = false)
    private Date fechaUtilizacion;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    public void setFechaAbierto(Date fechaCreacion2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFechaAbierto'");
    }

}