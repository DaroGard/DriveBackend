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
@Table(name = "tbl_tipos_direccion")
@Data
public class TiposDireccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_tipo_direccion")
    private int codigoTipoDireccion;

    @Column(name = "tipo_direccion")
    private String tipoDireccion;

    @JsonIgnore
    @OneToOne(mappedBy = "tipo_direccion")
    private Direcciones direccion;
}
