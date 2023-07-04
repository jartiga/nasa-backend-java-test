package com.nasa.prueba.aspirante.dominio.service;

import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.dto.PruebaResponseDto;

import java.util.List;

public interface PruebaService {
    List<PruebaResponseDto> getAllData();
    void saveData(List<PruebaDto> dtos);
}
