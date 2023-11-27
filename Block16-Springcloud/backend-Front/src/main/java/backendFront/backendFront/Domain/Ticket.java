package backendFront.backendFront.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue
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
