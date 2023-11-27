package block16springcloud.block16springcloud.dto;

import lombok.Data;

@Data
public class ClienteInputDto {
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private int telefono;
}
