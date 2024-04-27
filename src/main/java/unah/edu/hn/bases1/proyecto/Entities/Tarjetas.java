package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_tarjetas")
@Data
public class Tarjetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_tarjeta")
    private int codigoTarjeta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metodo_pago", referencedColumnName = "codigo_metodo_pago")
    private MetodosPago metodo_pago;

    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @Column(name = "codigo_seguridad")
    private int codigoSeguridad;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    @OneToOne(mappedBy = "tarjeta")
    private Usuarios usuario;
}
