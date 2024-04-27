package unah.edu.hn.bases1.proyecto.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_tipos_archivo")
@Data
public class TiposArchivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_tipo_archivo")
    private int codigoTipoArchivo;

    @Column(name = "tipo_archivo")
    private String tipoArchivo;

    private int peso;

    @JsonIgnore
    @OneToOne(mappedBy = "tipo_archivo")
    private Archivos archivo;
}
