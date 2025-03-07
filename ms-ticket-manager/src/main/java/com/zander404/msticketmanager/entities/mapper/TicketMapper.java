package com.zander404.msticketmanager.entities.mapper;

import com.zander404.msticketmanager.entities.Ticket;
import com.zander404.msticketmanager.entities.dto.TicketCreateDTO;
import com.zander404.msticketmanager.entities.dto.TicketResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketMapper {
    public static Ticket toTicket(TicketCreateDTO dto) {
        return new ModelMapper().map(dto, Ticket.class);
    }

    public static Ticket toTicket(TicketResponseDTO dto) {
        return new ModelMapper().map(dto, Ticket.class);
    }

    public static TicketResponseDTO toTicketResponseDTO(Ticket ticket) {
        return new ModelMapper().map(ticket, TicketResponseDTO.class);
    }

    public static List<TicketResponseDTO> toListDTO(List<Ticket> tickets) {
        return tickets.stream().map(TicketMapper::toTicketResponseDTO).collect(Collectors.toList());
    }
}
