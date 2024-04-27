package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_historial_cambios")
@Data
public class HistorialCambios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cambio")
    private int codigoCambio;

    @OneToOne
    @JoinColumn(name = "codigo_archivo", referencedColumnName = "codigo_archivo")
    private Archivos archivo;

    private String descripcion;

    @Column(name = "fecha_cambio")
    private Date fechaCambio;
}
