package unah.edu.hn.bases1.proyecto.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_carpetas")
@Data
public class Carpetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_carpeta")
    private int codigoCarpeta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado", referencedColumnName = "codigo_estado")
    private Estados estado;

    @OneToOne
    @JoinColumn(name = "carpeta_padre", referencedColumnName = "codigo_carpeta")
    private Carpetas carpeta_padre;

    @Column(name = "nombre_carpeta")
    private String nombreCarpeta;

    @OneToMany(mappedBy = "carpeta")
    private List<Archivos> archivo;

}
