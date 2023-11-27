package backendFront.backendFront.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue
    private Long idCliente;  // Esta propiedad se designa como la clave primaria
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private int telefono;

    // Getters and setters
}
