package com.zander404.msticketmanager.entities;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Data
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "ticket")
public class Ticket {


    @MongoId
    String ticketId = UUID.randomUUID().toString();

    @CPF
    String cpf;

    String customerName;

    @Email
    String customerMail;

    String eventId;

    String eventName;

    String BRLamount;

    String USDamount;

    String status;

}
