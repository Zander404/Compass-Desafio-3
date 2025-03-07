package com.zander404.mseventmanager.services;

import com.zander404.mseventmanager.entities.Event;
import com.zander404.mseventmanager.entities.dto.EventCreateDTO;
import com.zander404.mseventmanager.entities.dto.EventResponseDTO;
import com.zander404.mseventmanager.entities.mapper.EventMapper;
import com.zander404.mseventmanager.reposistory.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServices {

    @Autowired
    private EventRepository repository;

    public List<EventResponseDTO> getAll() {
        List<Event> events = repository.findAll();
        return EventMapper.toListDTO(events);
    }

    public EventResponseDTO getById(String id) {
        Event event = repository.findById(id).orElse(null);
        return EventMapper.toEventResponseDTO(event);
    }

    public EventResponseDTO create(EventCreateDTO dto) {
        try {
            Event event = EventMapper.toEvent(dto);
            repository.save(event);
            return EventMapper.toEventResponseDTO(event);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public EventResponseDTO update(String id, EventResponseDTO dto) {
        Event event = repository.findById(id).orElseThrow(RuntimeException::new);
        Event updatedEvent = EventMapper.toEvent(dto);
        updateInfo(event, updatedEvent);

        repository.save(event);
        return EventMapper.toEventResponseDTO(updatedEvent);
    }

    public void delete(String id) {
        Event event = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.delete(event);

    }


    private void updateInfo(Event obj, Event updateObj) {
        obj.setId(updateObj.getId());
        obj.setEventName(updateObj.getEventName());
        obj.setEventTime(updateObj.getEventTime());
        obj.setHasTicket(updateObj.getHasTicket());

        obj.setCep(updateObj.getCep());
        obj.setLogradouro(updateObj.getLogradouro());
        obj.setBairro(updateObj.getBairro());
        obj.setCidade(updateObj.getCidade());
        obj.setUf(updateObj.getUf());

    }
}
