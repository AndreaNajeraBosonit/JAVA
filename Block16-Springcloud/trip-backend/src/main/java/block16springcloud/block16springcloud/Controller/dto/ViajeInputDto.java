package block16springcloud.block16springcloud.Controller.dto;// ViajeInputDto.java

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViajeInputDto {
    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    private Long passengerId;
    private String status;
}
