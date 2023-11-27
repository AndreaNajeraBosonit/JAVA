package tripBackend.tripBackend.Controller.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteInputDto {
    Long idCliente;
     String nombre;
     String apellido;
     int edad;
     String email;
     int telefono;
}
