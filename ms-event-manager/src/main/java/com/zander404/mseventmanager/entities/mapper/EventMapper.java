package com.zander404.mseventmanager.entities.mapper;


import com.zander404.mseventmanager.entities.Event;
import com.zander404.mseventmanager.entities.dto.EventCreateDTO;
import com.zander404.mseventmanager.entities.dto.EventResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventMapper {

    public static Event toEvent(EventCreateDTO dto) {
        return new ModelMapper().map(dto, Event.class);
    };

    public static Event toEvent(EventResponseDTO dto) {
        return new ModelMapper().map(dto, Event.class);
    }

    public static EventResponseDTO toEventResponseDTO(Event event) {
        return new ModelMapper().map(event, EventResponseDTO.class);
    }

    public static List<EventResponseDTO> toListDTO(List<Event> events){
        return events.stream().map(EventMapper::toEventResponseDTO).collect(Collectors.toList());
    }
}
