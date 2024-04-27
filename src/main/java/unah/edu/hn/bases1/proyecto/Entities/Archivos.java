package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_archivos")
@Data
public class Archivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_archivo")
    private int codigoArchivo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado", referencedColumnName = "codigo_estado")
    private Estados estado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "codigo_usuario")
    private Usuarios usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carpeta", referencedColumnName = "codigo_carpeta")
    private Carpetas carpeta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_archivo", referencedColumnName = "codigo_tipo_archivo")
    private TiposArchivo tipo_archivo;

    @Column(name = "nombre_archivo")
    private String nombreArchivo;

    private String descripcion;

    @Column(name = "fecha_subido")
    private Date fechaSubido;

    @OneToOne(mappedBy = "archivo")
    private HistorialCambios historial_cambios;

    @OneToOne(mappedBy = "archivo")
    private Comentarios comentarios;

    @OneToOne(mappedBy = "archivo")
    private VersionesArchivo versiones_archivo;

}
