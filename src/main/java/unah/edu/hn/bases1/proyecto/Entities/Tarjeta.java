package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_tarjetas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private Integer idTarjeta;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "numero_tarjeta", nullable = false, length = 16)
    private String numeroTarjeta;

    @Column(name = "fecha_vencimiento", nullable = false)
    private Date fechaVencimiento;

    @Column(name = "codigo_postal", nullable = false, length = 3)
    private String codigoPostal;

    @Column(name = "codigo_seguridad", nullable = false, length = 3)
    private String codigoSeguridad;

}
