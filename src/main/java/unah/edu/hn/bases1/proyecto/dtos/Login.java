package unah.edu.hn.bases1.proyecto.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    private String correo;
    private String contrasena;
}
