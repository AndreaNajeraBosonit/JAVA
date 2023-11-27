package block16springcloud.block16springcloud.Service;

import block16springcloud.block16springcloud.Controller.dto.ClienteInputDto;
import block16springcloud.block16springcloud.Controller.dto.ClienteOutputDto;
import block16springcloud.block16springcloud.Domain.Cliente;
import block16springcloud.block16springcloud.Repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


    @Service
    public class ClienteServiceImpl implements ClienteService {

        private final ClienteRepository clienteRepository;

        @Autowired
        public ClienteServiceImpl(ClienteRepository clienteRepository) {
            this.clienteRepository = clienteRepository;
        }

        @Override
        public List<ClienteOutputDto> getAllClientes() {
            List<Cliente> clientes = clienteRepository.findAll();
            return clientes.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }

        @Override
        public ClienteOutputDto getClienteById(Long id) {
            Cliente cliente = clienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            return convertToDto(cliente);
        }

        @Override
        public ClienteOutputDto createCliente(ClienteInputDto clienteInputDto) {
            Cliente cliente = convertToEntity(clienteInputDto);
            Cliente savedCliente = clienteRepository.save(cliente);
            return convertToDto(savedCliente);
        }

        @Override
        public ClienteOutputDto updateCliente(Long id, ClienteInputDto clienteInputDto) {
            Cliente existingCliente = clienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

            BeanUtils.copyProperties(clienteInputDto, existingCliente);
            Cliente updatedCliente = clienteRepository.save(existingCliente);

            return convertToDto(updatedCliente);
        }

        @Override
        public void deleteCliente(Long id) {
            clienteRepository.deleteById(id);
        }

        private ClienteOutputDto convertToDto(Cliente cliente) {
            ClienteOutputDto clienteDto = new ClienteOutputDto();
            BeanUtils.copyProperties(cliente, clienteDto);
            return clienteDto;
        }

        private Cliente convertToEntity(ClienteInputDto clienteInputDto) {
            Cliente cliente = new Cliente();
            BeanUtils.copyProperties(clienteInputDto, cliente);
            return cliente;
        }
    }

