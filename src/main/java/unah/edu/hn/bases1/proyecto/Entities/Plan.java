package unah.edu.hn.bases1.proyecto.Entities;

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
@Table(name = "tbl_planes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private Integer idPlan;

    @ManyToOne
    @JoinColumn(name = "id_oferta", nullable = false)
    private Oferta oferta;

    @Column(name = "nombre_plan", nullable = false)
    private String nombrePlan;

    @Column(name = "almacenamiento", nullable = false)
    private Integer almacenamiento;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

}