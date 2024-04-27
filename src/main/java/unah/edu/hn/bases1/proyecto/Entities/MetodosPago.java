package unah.edu.hn.bases1.proyecto.Entities;

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
@Table(name = "tbl_metodos_pago")
@Data
public class MetodosPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_metodo_pago")
    private int codigoMetodoPago;

    @Column(name = "tipo_metodo_pago")
    private String tipoMetodoPago;

    @JsonIgnore
    @OneToMany(mappedBy = "metodo_pago")
    private List<Tarjetas> tarjeta;
}
