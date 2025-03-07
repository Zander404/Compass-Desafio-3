package com.zander404.mseventmanager.entities.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"eventName", "dateTime", "cep"})
public class EventCreateDTO {
    String eventName;
    String dateTime;
    String cep;
}
