// Viaje.java
package backendFront.backendFront.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "viaje")
public class Viaje {

    @Id
    @GeneratedValue
    private Long tripId;

    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    private Long passengerId;
    private String status;

    private int passengerCount;
}
