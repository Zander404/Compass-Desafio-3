package com.zander404.msticketmanager.reposistory;

import com.zander404.msticketmanager.entities.Ticket;
import com.zander404.msticketmanager.entities.dto.TicketResponseDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.lang.ScopedValue;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {
  Ticket findByTicketId(String id);
}
