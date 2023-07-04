package com.nasa.prueba.aspirante.dominio.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PruebaResponseDto extends PruebaDto {
    private Long id;
    private LocalDateTime modifiedDate;
}
