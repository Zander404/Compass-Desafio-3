package com.zander404.msticketmanager.entities.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor @AllArgsConstructor
@JsonPropertyOrder({"ticketId", "cpf", "customerName", "customerMail", "eventId", "eventName", "brlamount", "usdamount", "status"})
public class TicketResponseDTO {

    String ticketId;
    String customerName;

    @CPF
    String cpf;

    String customerMail;

    String eventId;
    String eventName;
    String BRLamount;
    String USDamount;
    String status;

}
