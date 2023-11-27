package block16springcloud.block16springcloud.Service;

import block16springcloud.block16springcloud.Controller.dto.ClienteInputDto;
import block16springcloud.block16springcloud.Controller.dto.ClienteOutputDto;

import java.util.List;

public interface ClienteService {
    List<ClienteOutputDto> getAllClientes();
    ClienteOutputDto getClienteById(Long id);
    ClienteOutputDto createCliente(ClienteInputDto clienteInputDto);
    ClienteOutputDto updateCliente(Long id, ClienteInputDto clienteInputDto);
    void deleteCliente(Long id);
}