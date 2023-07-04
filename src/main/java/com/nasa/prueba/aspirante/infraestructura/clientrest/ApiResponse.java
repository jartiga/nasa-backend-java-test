package com.nasa.prueba.aspirante.infraestructura.clientrest;

import com.nasa.prueba.aspirante.dominio.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private Collection collection;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Collection {
        List<ItemDto> items;
    }

}
