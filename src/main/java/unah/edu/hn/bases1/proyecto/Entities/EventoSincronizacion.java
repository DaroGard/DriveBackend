package unah.edu.hn.bases1.proyecto.Entities;

import java.util.Date;

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
@Table(name = "tbl_eventos_sincronizacion")
@NoArgsConstructor
@AllArgsConstructor
public class EventoSincronizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    private String tipoEvento;
    private Date fecha;
    private String resultado;

}