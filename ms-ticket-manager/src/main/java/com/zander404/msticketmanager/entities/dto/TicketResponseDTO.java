package com.zander404.msticketmanager.entities.dto;

import org.hibernate.validator.constraints.br.CPF;

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
