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
@Table(name = "tbl_permisos")
@Data
public class Permisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_permiso")
    private int codigoPermiso;

    @Column(name = "tipo_permiso")
    private String tipoPermiso;

    @ManyToMany(mappedBy = "permisos")
    private List<Compartidos> compartidos;
}
