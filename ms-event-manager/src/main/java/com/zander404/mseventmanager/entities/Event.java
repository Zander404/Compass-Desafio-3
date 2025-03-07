package com.zander404.mseventmanager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Event implements Serializable {

    @MongoId
    String id;
    String eventName;
    LocalDateTime eventTime;
    String cep;
    String logradouro;
    String bairro;
    String cidade;
    String uf;
    String hasTicket;
}
