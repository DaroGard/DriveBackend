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
@Table(name = "tbl_notificaciones")
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Long idNotificacion;

    @Column(name = "id_usuario_destino", nullable = false)
    private Long idUsuarioDestino;

    @Column(name = "mensaje", nullable = false, length = 500)
    private String mensaje;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "leido")
    private Boolean leido = false;
}