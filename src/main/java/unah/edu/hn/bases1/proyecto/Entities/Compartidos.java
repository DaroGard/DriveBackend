package unah.edu.hn.bases1.proyecto.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_compartidos")
@Data
public class Compartidos {

    @Id
    @OneToOne
    @JoinColumn(name = "archivo", referencedColumnName = "codigo_archivo")
    private Archivos archivo;

    @OneToOne
    @JoinColumn(name = "usuario_propietario", referencedColumnName = "codigo_usuario")
    private Usuarios usuario_propietario;

    @OneToOne
    @JoinColumn(name = "usuario_compartido", referencedColumnName = "codigo_usuario")
    private Usuarios usuario_compartido;

    @ManyToMany
    @JoinTable(name = "tbl_compartidos_x_permisos", joinColumns = @JoinColumn(name = "archivo"), inverseJoinColumns = @JoinColumn(name = "permiso"))
    private List<Permisos> permisos;
}
