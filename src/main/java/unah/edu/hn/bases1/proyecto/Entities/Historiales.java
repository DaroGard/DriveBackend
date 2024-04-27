package unah.edu.hn.bases1.proyecto.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_historiales")
@Data
public class Historiales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_historial")
    private int codigoHistorial;

    private String historial;

    private String estado;

    @ManyToMany(mappedBy = "historiales")
    private List<DatosPrivacidad> datosprivacidad;
}
