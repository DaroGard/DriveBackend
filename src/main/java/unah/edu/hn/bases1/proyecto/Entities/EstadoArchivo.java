package unah.edu.hn.bases1.proyecto.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_estados_archivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoArchivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer idEstado;

    @Column(name = "tipo_estado", nullable = false)
    private String tipoEstado;

    @JsonIgnoreProperties("estadoArchivo")
    @OneToMany(mappedBy = "estadoArchivo")
    private List<Archivo> archivos;

}
