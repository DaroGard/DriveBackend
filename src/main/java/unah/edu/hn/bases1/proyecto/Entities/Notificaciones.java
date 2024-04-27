package unah.edu.hn.bases1.proyecto.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_notificaciones")
@Data
public class Notificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_notificacion")
    private int codigoNotificacion;

    @OneToOne
    @JoinColumn(name = "tipos_notif", referencedColumnName = "codigo_tipos_notif")
    private TiposNotificaciones tipo_notificacion;

    private String descripcion;

    @ManyToMany(mappedBy = "notificaciones")
    private List<Usuarios> usuarios;
}
