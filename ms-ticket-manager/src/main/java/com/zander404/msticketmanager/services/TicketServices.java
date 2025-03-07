package com.zander404.msticketmanager.services;

import com.zander404.msticketmanager.entities.Ticket;
import com.zander404.msticketmanager.entities.dto.TicketCreateDTO;
import com.zander404.msticketmanager.entities.dto.TicketResponseDTO;
import com.zander404.msticketmanager.entities.mapper.TicketMapper;
import com.zander404.msticketmanager.reposistory.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServices {

    @Autowired
    private TicketRepository repository;

    public List<TicketResponseDTO> getAllTickets() {
        List<Ticket> tickets = repository.findAll();
        return TicketMapper.toListDTO(tickets);
    }

    public TicketResponseDTO getTicketById(String ticketId) {
        Ticket ticket = repository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
        return TicketMapper.toTicketResponseDTO(ticket);
    }

    public TicketResponseDTO create(TicketCreateDTO createDTO) {

        try {
            Ticket ticket = TicketMapper.toTicket(createDTO);
            repository.save(ticket);
            return TicketMapper.toTicketResponseDTO(ticket);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TicketResponseDTO update(String id, TicketResponseDTO updateObjectDTO) {
        Ticket ticket = repository.findById(id).orElseThrow(() -> new RuntimeException());
        Ticket updateTicket = TicketMapper.toTicket(updateObjectDTO);
        updateInfo(ticket, updateTicket);
        repository.save(ticket);

        return TicketMapper.toTicketResponseDTO(ticket);
    }

    public void delete(String id) {
        Ticket ticket = repository.findById(id).orElseThrow(() -> new RuntimeException());
        repository.delete(ticket);
    }


    private void updateInfo(Ticket obj, Ticket updateObj) {

        obj.setCpf(updateObj.getCpf());
        obj.setCustomerMail(updateObj.getCustomerMail());
        obj.setCustomerMail(updateObj.getCustomerMail());
        obj.setEventId(updateObj.getEventId());
        obj.setEventName(updateObj.getEventName());
        obj.setBRLamount(updateObj.getBRLamount());
        obj.setUSDamount(updateObj.getUSDamount());
        obj.setStatus(updateObj.getStatus());
    }

}
