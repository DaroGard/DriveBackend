package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_ofertas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta")
    private Integer idOferta;

    @Column(name = "descuento", nullable = false)
    private Double descuento;

    @Column(name = "fecha_vencimiento", nullable = false)
    private Date fechaVencimiento;

    @Column(name = "estado", nullable = false)
    private String estado;

}
