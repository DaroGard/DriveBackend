package unah.edu.hn.bases1.proyecto.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_tipo_preferencia")
@Data
public class TipoPreferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_tipo_preferencia")
    private int codigoTipoPreferencia;

    @Column(name = "tipo_preferencia")
    private String tipoPreferencia;

    @OneToOne(mappedBy = "tipo_preferencia")
    private Preferencias preferencias;
}
