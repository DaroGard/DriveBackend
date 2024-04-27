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
@Table(name = "tbl_estados")
@Data
public class Estados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_estado")
    private int codigoEstado;

    private String estado;

    @JsonIgnore
    @OneToOne(mappedBy = "estado")
    private Carpetas carpeta;

    @JsonIgnore
    @OneToOne(mappedBy = "estado")
    private Archivos archivo;
}
