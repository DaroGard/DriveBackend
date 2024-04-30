package unah.edu.hn.bases1.proyecto.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_etiquetas")
@NoArgsConstructor
@AllArgsConstructor
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etiqueta")
    private Long id;

    @Column(name = "nombre_etiqueta", unique = true, nullable = false)
    private String nombreEtiqueta;

    @Column(name = "color")
    private String color;
}