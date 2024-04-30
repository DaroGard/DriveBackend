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
@Table(name = "tbl_actividades_usuario")
@NoArgsConstructor
@AllArgsConstructor
public class ActividadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Long idActividad;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "tipo_actividad", nullable = false)
    private String tipoActividad;

    @Column(name = "id_archivo")
    private Long idArchivo;

    @Column(name = "id_carpeta")
    private Long idCarpeta;

    @Column(name = "fecha", nullable = false)
    private Date fecha;
}