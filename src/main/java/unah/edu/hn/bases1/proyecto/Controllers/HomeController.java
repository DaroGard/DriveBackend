package unah.edu.hn.bases1.proyecto.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/GoogleDrive")
public class HomeController {

    @GetMapping("/Principal")
    public ModelAndView vistaPrincipal() {
        return new ModelAndView("VistaPrincipal");
    }

}
