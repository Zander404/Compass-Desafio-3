package com.zander404.mseventmanager.controller;

import com.zander404.mseventmanager.entities.Event;
import com.zander404.mseventmanager.entities.dto.EventCreateDTO;
import com.zander404.mseventmanager.entities.dto.EventResponseDTO;
import com.zander404.mseventmanager.services.EventServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Event")
@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    @Autowired
    private EventServices service;

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getEvents() {



        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEventById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<EventResponseDTO> createEvent(@RequestBody EventCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponseDTO> updateEvent(@PathVariable("id") String id, @RequestBody EventCreateDTO dto) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventResponseDTO> deleteEvent(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
