package tripBackend.tripBackend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tripBackend.tripBackend.Domain.Viaje;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
}
