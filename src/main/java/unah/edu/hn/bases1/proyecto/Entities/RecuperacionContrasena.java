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
@Table(name = "tbl_recuperacion_contrasena")
@NoArgsConstructor
@AllArgsConstructor
public class RecuperacionContrasena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Long idSolicitud;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "token", nullable = false, length = 100)
    private String token;

    @Column(name = "fecha_solicitud", nullable = false)
    private Date fechaSolicitud;

    @Column(name = "utilizado")
    private Boolean utilizado = false;
}