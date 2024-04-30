package unah.edu.hn.bases1.proyecto.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_configuracion_aplicacion")
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracionAplicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConfiguracion;

    private String nombre;
    private String valor;

}