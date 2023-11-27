package block16springcloud.block16springcloud.Repository;

import block16springcloud.block16springcloud.Domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import block16springcloud.block16springcloud.Domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>  {
    // Puedes agregar consultas personalizadas si es necesario
}
