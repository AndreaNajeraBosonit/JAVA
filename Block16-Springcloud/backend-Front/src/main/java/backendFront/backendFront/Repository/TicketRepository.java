package backendFront.backendFront.Repository;

import backendFront.backendFront.Domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
