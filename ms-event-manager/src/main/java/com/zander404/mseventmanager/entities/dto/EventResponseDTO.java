package com.zander404.mseventmanager.entities.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "eventName", "dateTime", "cep", "logradouro", "bairro", "cidade", "uf"})
public class EventResponseDTO {
    String id;
    String eventName;
    String dateTime;
    String hasEvent;
    String cep;
    String logradouro;
    String bairro;
    String cidade;
    String uf;
}
