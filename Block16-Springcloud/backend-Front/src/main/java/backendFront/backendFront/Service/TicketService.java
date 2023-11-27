package backendFront.backendFront.Service;


import backendFront.backendFront.Controller.dto.TicketInputDto;
import backendFront.backendFront.Controller.dto.TicketOutputDto;

public interface TicketService {
    TicketOutputDto generateTicket(TicketInputDto ticketInputDto);
}
