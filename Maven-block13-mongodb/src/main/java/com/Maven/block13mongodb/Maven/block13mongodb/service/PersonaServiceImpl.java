import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Page<Persona> obtenerPersonas(int pagina, int tamañoPagina) {
        PageRequest pageable = PageRequest.of(pagina, tamañoPagina);
        return personaRepository.findAll(pageable);
    }

    public Persona obtenerPersonaPorId(String id) {
        return personaRepository.findById(id).orElse(null);
    }

    public void eliminarPersona(String id) {
        personaRepository.deleteById(id);
    }

    public Persona actualizarPersona(String id, Persona persona) {
        if (personaRepository.existsById(id)) {
            persona.setId(id);
            return personaRepository.save(persona);
        }
        return null;
    }
}
