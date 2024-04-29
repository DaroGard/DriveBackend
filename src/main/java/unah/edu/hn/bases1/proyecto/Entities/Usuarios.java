package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_usuarios")
@Data
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private int codigoUsuario;

    @OneToOne
    @JoinColumn(name = "preferencia", referencedColumnName = "codigo_preferencia")
    private Preferencias preferencia;

    @OneToOne
    @JoinColumn(name = "tarjeta", referencedColumnName = "codigo_tarjeta")
    private Tarjetas tarjeta;

    @OneToOne
    @JoinColumn(name = "datos_priv", referencedColumnName = "codigo_datos_priv")
    private DatosPrivacidad datos_privacidad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plan", referencedColumnName = "codigo_plan")
    private Planes plan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion", referencedColumnName = "codigo_direccion")
    private Direcciones direccion;

    @Column(name = "fotoperfil")
    private String fotoPerfil;

    private String nombre;

    private String apellido;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    private String genero;

    private String correo;

    private String clave;

    @Column(name = "correo_adicional")
    private String correoAdicional;

    private String telefono;

    private String formacion;

    private String trabajo;

    @OneToOne(mappedBy = "usuario")
    private Computadoras computadora;

    @OneToMany(mappedBy = "usuario")
    private List<Archivos> archivos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_notificaciones_x_usr", joinColumns = @JoinColumn(name = "codigo_usuario"), inverseJoinColumns = @JoinColumn(name = "codigo_notificacion"))
    private List<Notificaciones> notificaciones;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_grupos_x_usuarios", joinColumns = @JoinColumn(name = "codigo_usuario"), inverseJoinColumns = @JoinColumn(name = "codigo_grupo"))
    private List<Grupos> grupos;

    @OneToOne(mappedBy = "usuario")
    private VersionesArchivo versiones_archivo;

    @OneToOne(mappedBy = "usuario")
    private Comentarios comentarios;

    @OneToOne(mappedBy = "usuario_propietario")
    private Compartidos compartido_propietario;

    @OneToOne(mappedBy = "usuario_compartido")
    private Compartidos compartidos;

    @OneToOne(mappedBy = "usuario")
    private Etiquetas etiquetas;

    @OneToOne(mappedBy = "usuario")
    private RegistrosActividades registros_actividades;
}
