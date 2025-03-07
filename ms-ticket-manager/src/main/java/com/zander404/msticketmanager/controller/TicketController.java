package com.zander404.msticketmanager.controller;

import com.zander404.msticketmanager.entities.dto.TicketCreateDTO;
import com.zander404.msticketmanager.entities.dto.TicketResponseDTO;
import com.zander404.msticketmanager.services.TicketServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Teste")
@RestController
@RequestMapping(value = "api/v1/ticket")
public class TicketController {

    @Autowired
    private TicketServices service;
    @Autowired
    private TicketServices ticketServices;

    @GetMapping(value = "/")
    @Operation(
            summary = "Finds all Tickets", description = "Find All Tickets in the DB",
            responses = {
                    @ApiResponse(
                            description = "SUCCESS", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TicketResponseDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })

    public ResponseEntity<List<TicketResponseDTO>> getAll() {
        List<TicketResponseDTO> tickets = service.getAllTickets();
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping(value = "/{id}")
    @Operation(
            summary = "Finds By ID ONE Tickets", description = "Retrieve one Ticket by the ID informed",
            responses = {
                    @ApiResponse(
                            description = "SUCCESS", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TicketResponseDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<TicketResponseDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.getTicketById(id));
    }

    @PostMapping
    @Operation(
            summary = "Create A New TICKET", description = "Create a new Ticket using the pass information",
            responses = {
                    @ApiResponse(
                            description = "CREATED", responseCode = "201",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TicketResponseDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<TicketResponseDTO> create(@RequestBody TicketCreateDTO createDTO) {
        TicketResponseDTO response = service.create(createDTO);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping(value = "/{id}")
    @Operation(
            summary = "Update One Ticket", description = "Update the inforamtion of the Ticket with that ID for the provided information",
            responses = {
                    @ApiResponse(
                            description = "NO CONTENT", responseCode = "204",
                            content = {
                                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TicketResponseDTO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<TicketResponseDTO> update(@PathVariable String id, @RequestBody TicketResponseDTO ticketDTO) {
        TicketResponseDTO response = service.update(id, ticketDTO);
        return ResponseEntity.status(204).body(response);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Delete One Ticket", description = "Delete the Ticket by ID",
            responses = {
                    @ApiResponse(description = "NO CONTENT", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })

    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

