package tripBackend.tripBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tripBackend.tripBackend.Controller.dto.ClienteInputDto;
import tripBackend.tripBackend.Controller.dto.ClienteOutputDto;
import tripBackend.tripBackend.Service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteOutputDto> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ClienteOutputDto getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public ClienteOutputDto createCliente(@RequestBody ClienteInputDto clienteInputDto) {
        return clienteService.createCliente(clienteInputDto);
    }

    @PutMapping("/{id}")
    public ClienteOutputDto updateCliente(@PathVariable Long id, @RequestBody ClienteInputDto clienteInputDto) {
        return clienteService.updateCliente(id, clienteInputDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
}
