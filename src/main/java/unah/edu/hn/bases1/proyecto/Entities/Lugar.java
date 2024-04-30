package unah.edu.hn.bases1.proyecto.Entities;

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
@Table(name = "tbl_lugares")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lugar")
    private Integer idLugar;

    @ManyToOne
    @JoinColumn(name = "id_lugar_padre")
    private Lugar lugarPadre;

    @Column(name = "id_tipo_lugar", nullable = false)
    private Integer idTipoLugar;

    @Column(name = "nombre_lugar", nullable = false)
    private String nombreLugar;

}