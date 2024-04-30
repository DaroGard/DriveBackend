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
@Table(name = "tbl_compartidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compartido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compartido")
    private Integer idCompartido;

    @ManyToOne
    @JoinColumn(name = "id_archivo", nullable = false)
    private Archivo archivo;

    @ManyToOne
    @JoinColumn(name = "id_permiso", nullable = false)
    private Permiso permiso;

    @ManyToOne
    @JoinColumn(name = "id_usuario_propietario", nullable = false)
    private Usuario usuarioPropietario;

    @ManyToOne
    @JoinColumn(name = "id_usuario_compartido", nullable = false)
    private Usuario usuarioCompartido;

    @Column(name = "fecha_compartido", nullable = false)
    private Date fechaCompartido;

    @Column(name = "ultima_modificacion")
    private Date ultimaModificacion;

}