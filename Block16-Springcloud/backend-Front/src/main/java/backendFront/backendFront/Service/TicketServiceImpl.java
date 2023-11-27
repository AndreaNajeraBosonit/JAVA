package backendFront.backendFront.Service;

import backendFront.backendFront.Controller.dto.TicketInputDto;
import backendFront.backendFront.Controller.dto.TicketOutputDto;
import backendFront.backendFront.Domain.Cliente;
import backendFront.backendFront.Domain.Ticket;
import backendFront.backendFront.Domain.Viaje;
import backendFront.backendFront.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public TicketOutputDto generateTicket(TicketInputDto ticketInputDto) {
        // Obtener información del pasajero y del viaje utilizando RestTemplate
        Cliente clienteDto = restTemplate.getForObject("http://localhost:8000/clientes/{idCliente}", Cliente.class, ticketInputDto.getIdCliente());
        Viaje viajeDto = restTemplate.getForObject("http://localhost:8000/trip/{tripId}", Viaje.class, ticketInputDto.getTripId());

        // Crear el objeto Ticket y asignar los datos del DTO
        Ticket ticket = new Ticket();
        ticket.setPassengerId(clienteDto.getIdCliente());
        ticket.setPassengerName(clienteDto.getNombre());
        ticket.setPassengerLastName(clienteDto.getApellido());
        ticket.setPassengerEmail(clienteDto.getEmail());
        ticket.setTripOrigin(viajeDto.getOrigin());
        ticket.setTripDestination(viajeDto.getDestination());
        ticket.setDepartureDate(viajeDto.getDepartureDate());
        ticket.setArrivalDate(viajeDto.getArrivalDate());

        // Guardar el Ticket en el repositorio
        Ticket savedTicket = ticketRepository.save(ticket);

        // Crear y retornar el TicketOutputDto con la información que desees
        TicketOutputDto ticketOutputDto = new TicketOutputDto();
        ticketOutputDto.setId(savedTicket.getId());
        ticketOutputDto.setPassengerId(savedTicket.getPassengerId());
        ticketOutputDto.setPassengerName(savedTicket.getPassengerName());
        ticketOutputDto.setPassengerLastName(savedTicket.getPassengerLastName());
        ticketOutputDto.setPassengerEmail(savedTicket.getPassengerEmail());
        ticketOutputDto.setTripOrigin(savedTicket.getTripOrigin());
        ticketOutputDto.setTripDestination(savedTicket.getTripDestination());
        ticketOutputDto.setDepartureDate(savedTicket.getDepartureDate());
        ticketOutputDto.setArrivalDate(savedTicket.getArrivalDate());

        return ticketOutputDto;
    }

}
