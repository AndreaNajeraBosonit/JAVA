package block16springcloud.block16springcloud.Controller;

import block16springcloud.block16springcloud.Controller.dto.ClienteInputDto;
import block16springcloud.block16springcloud.Controller.dto.ClienteOutputDto;
import block16springcloud.block16springcloud.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
