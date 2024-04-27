package unah.edu.hn.bases1.proyecto.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_tipos_notificaciones")
@Data
public class TiposNotificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_tipos_notif")
    private int codigoTiposNotificacion;

    @Column(name = "tipo_notificacion")
    private String tipoNotificacion;

    @OneToOne(mappedBy = "tipo_notificacion")
    private Notificaciones notificaciones;
}
