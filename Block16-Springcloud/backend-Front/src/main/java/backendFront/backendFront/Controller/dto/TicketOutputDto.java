package backendFront.backendFront.Controller.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketOutputDto {
    private Long id;
    private Long passengerId;
    private String passengerName;
    private String passengerLastName;
    private String passengerEmail;
    private String tripOrigin;
    private String tripDestination;
    private String departureDate;
    private String arrivalDate;
}
