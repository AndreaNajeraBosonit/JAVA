package block16springcloud.block16springcloud.Controller.dto;

import jakarta.persistence.Entity;
import lombok.*;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteOutputDto {
    private Long idCliente;
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private int telefono;
}
