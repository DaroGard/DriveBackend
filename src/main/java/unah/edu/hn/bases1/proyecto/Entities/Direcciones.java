package unah.edu.hn.bases1.proyecto.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name = "tbl_direcciones")
@Data
public class Direcciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_direccion")
    private int codigoDireccion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_direccion", referencedColumnName = "codigo_tipo_direccion")
    private TiposDireccion tipo_direccion;

    @JsonIgnore
    @OneToOne(mappedBy = "direccion")
    private Usuarios usuario;
}
