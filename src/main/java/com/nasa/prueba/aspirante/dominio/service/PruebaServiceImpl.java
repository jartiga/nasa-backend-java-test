package com.nasa.prueba.aspirante.dominio.service;

import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.dto.PruebaResponseDto;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PruebaServiceImpl implements PruebaService {

    private final PruebaInterfaz pruebaInterfaz;

    public List<PruebaResponseDto> getAllData() {
        List<PruebaEntity> entities = pruebaInterfaz.findAll(Sort.by(Sort.Order.desc("id")));
        return entities.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public void saveData(List<PruebaDto> dtos) {
        List<PruebaEntity> entities = dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
        pruebaInterfaz.saveAll(entities);
    }

    private PruebaEntity mapToEntity(PruebaDto dto) {
        PruebaEntity entity = new PruebaEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private PruebaResponseDto mapToDto(PruebaEntity entity) {
        PruebaResponseDto dto = new PruebaResponseDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

}
