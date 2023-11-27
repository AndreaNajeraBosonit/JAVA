package block16springcloud.block16springcloud.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "autobus")
public class Viaje {
    @Id
    @GeneratedValue
    Long idAutobus;
    String origin;
    String destination;

    String departureDate;

    String arrivalDate;
    String passenger ;
    String status;

}

