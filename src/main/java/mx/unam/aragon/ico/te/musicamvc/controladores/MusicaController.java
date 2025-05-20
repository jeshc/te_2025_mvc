package mx.unam.aragon.ico.te.musicamvc.controladores;

import mx.unam.aragon.ico.te.musicamvc.modelos.Artista;
import mx.unam.aragon.ico.te.musicamvc.servicios.ArtistaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tienda")
public class MusicaController {
    @Autowired
    private ArtistaService artistaService;

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
        artistaService.guardarArtista(artista);
        return "redirect:/tienda/nuevo?exito";
    }

    @GetMapping("/artista/{id}")
    public String artista(@PathVariable Integer id, Model model) {
        model.addAttribute("artista",artistaService.getArtista(id));
        return "artista";
    }

}
