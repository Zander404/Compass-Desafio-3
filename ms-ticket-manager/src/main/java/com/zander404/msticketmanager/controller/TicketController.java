package com.zander404.msticketmanager.controller;

import com.zander404.msticketmanager.entities.dto.TicketResponseDTO;
import com.zander404.msticketmanager.services.TicketServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Teste")
@RestController
@RequestMapping(value = "api/v1/ticket")
public class TicketController {

    @Autowired
    private TicketServices service;

    @GetMapping
    public String test() {
        return "test";
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<TicketResponseDTO>> getAll() {
        List<TicketResponseDTO> tickets = service.getAllTickets();
        return ResponseEntity.ok().body(tickets);
    }

}

