package block16springcloud.block16springcloud.Controller.dto;

import jakarta.persistence.Entity;
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
