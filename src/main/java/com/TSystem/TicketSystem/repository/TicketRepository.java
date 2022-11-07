package com.TSystem.TicketSystem.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.TSystem.TicketSystem.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
    List<Ticket> findByTitleContaining(String title);
    
}