package com.zander404.msticketmanager.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketCreateDTO implements Serializable {

    String ticketId;
    String customerName;

    @CPF
    String cpf;

    String customerMail;
    String eventId;
    String eventName;
    String BRLamount;
    String USDamount;


}
