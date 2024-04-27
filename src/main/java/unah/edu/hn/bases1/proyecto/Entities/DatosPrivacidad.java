package unah.edu.hn.bases1.proyecto.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_datos_privacidad")
@Data
public class DatosPrivacidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_datos_priv")
    private int codigoDatosPriv;

    private String verificacion;

    @OneToOne(mappedBy = "datos_privacidad")
    private Usuarios usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_datos_x_historial", joinColumns = @JoinColumn(name = "datos_priv"), inverseJoinColumns = @JoinColumn(name = "historial"))
    private List<Historiales> historiales;
}
