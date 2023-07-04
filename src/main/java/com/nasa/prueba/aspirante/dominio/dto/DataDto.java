package com.nasa.prueba.aspirante.dominio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {
    private String center;
    private String title;
    @JsonProperty(value = "nasa_id")
    private String nasaId;
}
