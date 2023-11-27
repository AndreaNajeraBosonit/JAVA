package tripBackend.tripBackend.Controller.dto;// ViajeOutputDto.java

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViajeOutputDto {
    private Long tripId;
    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    private Long passengerId;
    private String status;
}
