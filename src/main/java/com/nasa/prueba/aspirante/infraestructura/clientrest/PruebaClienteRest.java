package com.nasa.prueba.aspirante.infraestructura.clientrest;

import com.nasa.prueba.aspirante.dominio.dto.ItemDto;
import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class PruebaClienteRest {

    private final RestTemplate restTemplate;

    @Value("${nasa.search.param:apollo 2011}")
    private String param;

    public List<PruebaDto> searchNasaImages() {

        String url = "https://images-api.nasa.gov/search?q={param}";
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class, param);
        ApiResponse apiResponse = response.getBody();

        List<PruebaDto> data = apiResponse.getCollection().getItems().stream().map(this::mapToDto).collect(Collectors.toList());

        log.info("DATOS RECIBIDOS: "+data.size());
        return data;
    }

    private PruebaDto mapToDto(ItemDto data) {
        PruebaDto dto = new PruebaDto();
        dto.setHref(data.getHref());
        dto.setCenter(data.getData().get(0).getCenter());
        dto.setTitle(data.getData().get(0).getTitle());
        dto.setNasaId(data.getData().get(0).getNasaId());
        return dto;
    }

}
