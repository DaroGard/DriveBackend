package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_planes")
@Data
public class Planes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_plan")
    private int codigoPlan;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "oferta", referencedColumnName = "codigo_oferta")
    private Ofertas oferta;

    @Column(name = "nombre_plan")
    private String nombrePlan;

    private Date duracion;

    private String descripcion;

    private int precio;

    private int almacenamiento;

    @JsonIgnore
    @OneToMany(mappedBy = "plan")
    private List<Usuarios> usuario;
}
