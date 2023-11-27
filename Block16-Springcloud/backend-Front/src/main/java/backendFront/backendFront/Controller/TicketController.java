package backendFront.backendFront.Controller;

import backendFront.backendFront.Controller.dto.TicketInputDto;
import backendFront.backendFront.Controller.dto.TicketOutputDto;
import backendFront.backendFront.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/generateTicket/{idCliente}/{tripId}")
    public ResponseEntity<TicketOutputDto> generateTicket(
            @PathVariable Long idCliente,
            @PathVariable Long tripId
    ) {
        TicketInputDto ticketInputDto = new TicketInputDto(idCliente, tripId);
        TicketOutputDto generatedTicket = ticketService.generateTicket(ticketInputDto);
        return ResponseEntity.ok(generatedTicket);
    }
}
