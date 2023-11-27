package tripBackend.tripBackend.Service;


import tripBackend.tripBackend.Controller.dto.ClienteInputDto;
import tripBackend.tripBackend.Controller.dto.ClienteOutputDto;

import java.util.List;

public interface ClienteService {
    List<ClienteOutputDto> getAllClientes();
    ClienteOutputDto getClienteById(Long id);
    ClienteOutputDto createCliente(ClienteInputDto clienteInputDto);
    ClienteOutputDto updateCliente(Long id, ClienteInputDto clienteInputDto);
    void deleteCliente(Long id);
}