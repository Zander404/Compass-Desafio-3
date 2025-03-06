package com.zander404.msticketmanager.entities;


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
@Document
public class Ticket {


    @MongoId
    UUID ticketId = UUID.randomUUID();

    @CPF
    String cpf;

    String customerName;

    @Email
    String customerMail;

    String eventId;
}
