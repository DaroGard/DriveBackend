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

@Data
@Entity
@Table(name = "tbl_comentarios")
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long idComentario;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_archivo")
    private Long idArchivo;

    @Column(name = "id_carpeta")
    private Long idCarpeta;

    @Column(name = "texto_comentario", nullable = false, length = 500)
    private String textoComentario;

    @Column(name = "fecha", nullable = false)
    private Date fecha;
}