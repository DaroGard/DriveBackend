package unah.edu.hn.bases1.proyecto.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carpeta {
    private String nombre;
    private int propietaro;
    private Date fechaCreacion;
    private int ubicacion;
}
