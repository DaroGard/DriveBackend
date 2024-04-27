package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_ofertas")
@Data
public class Ofertas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_oferta")
    private int codigoOferta;

    private int descuento;

    private Date duracion;

    @JsonIgnore
    @OneToMany(mappedBy = "oferta")
    private List<Planes> plan;
}
