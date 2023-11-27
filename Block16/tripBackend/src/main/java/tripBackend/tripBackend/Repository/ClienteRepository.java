package tripBackend.tripBackend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tripBackend.tripBackend.Domain.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
