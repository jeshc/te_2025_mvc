package mx.unam.aragon.ico.te.musicamvc.controladores;

import mx.unam.aragon.ico.te.musicamvc.modelos.Artista;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tienda")
public class MusicaController {

    @GetMapping("/home/")
    public String home() {
        return "home";
    }

    @GetMapping("/artista/")
    public String artista(Model model) {
        Artista artista = new Artista("Algo",25,"Rock",1,"https://upload.wikimedia.org/wikipedia/commons/9/96/Freddie_Mercury_%281977_Press_Kit_Photo%29.jpg", "Freddie Mercury");
        model.addAttribute("artista", artista);
        return "artista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("artista", new Artista("cc",23,"Rock",0,"http:algo","Maria"));
        return "formArtista";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Artista artista
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardando artista +  " + artista);
        // mandarlo a BD (save)
        return "redirect:/tienda/nuevo?exito";
    }


}
