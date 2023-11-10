import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.guardarPersona(persona);
    }

    @GetMapping
    public Page<Persona> obtenerPersonas(@RequestParam(defaultValue = "0") int pagina,
                                         @RequestParam(defaultValue = "10") int tamañoPagina) {
        return personaService.obtenerPersonas(pagina, tamañoPagina);
    }

    @GetMapping("/{id}")
    public Persona obtenerPersonaPorId(@PathVariable String id) {
        return personaService.obtenerPersonaPorId(id);
    }

    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable String id, @RequestBody Persona persona) {
        return personaService.actualizarPersona(id, persona);
    }

    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable String id) {
        personaService.eliminarPersona(id);
    }
}
