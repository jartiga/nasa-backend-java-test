package com.nasa.prueba.aspirante.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private String href;
    private List<DataDto> data;

}
