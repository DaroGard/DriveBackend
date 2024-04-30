package unah.edu.hn.bases1.proyecto.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_tipos_archivos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoArchivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_archivo")
    private Integer idTipoArchivo;

    @Column(name = "tipo_archivo", nullable = false)
    private String tipoArchivo;

}