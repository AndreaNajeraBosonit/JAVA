package block16springcloud.block16springcloud.Repository;

import block16springcloud.block16springcloud.Domain.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
}
