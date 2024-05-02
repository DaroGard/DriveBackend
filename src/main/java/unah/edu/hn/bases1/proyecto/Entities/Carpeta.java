package unah.edu.hn.bases1.proyecto.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_carpetas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carpeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carpeta")
    private Integer idCarpeta;

    @ManyToOne
    @JoinColumn(name = "id_carpeta_padre")
    private Carpeta carpetaPadre;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadoCarpeta estadoCarpeta;

    @Column(name = "nombre_carpeta")
    private String nombreCarpeta;

    @JsonIgnoreProperties("carpeta")
    @OneToMany(mappedBy = "carpeta")
    private List<Archivo> archivos;

}