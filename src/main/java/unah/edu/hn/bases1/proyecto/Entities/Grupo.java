package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_grupos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "nombre_grupo", nullable = false)
    private String nombreGrupo;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @ManyToMany
    @JoinTable(name = "tbl_usuarios_grupo", joinColumns = @JoinColumn(name = "id_grupo"), inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private List<Usuario> usuarios;

}