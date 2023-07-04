package com.nasa.prueba.aspirante.infraestructura.restcontroller;


import com.nasa.prueba.aspirante.dominio.dto.PruebaResponseDto;
import com.nasa.prueba.aspirante.dominio.service.PruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PruebaRestController {

    private final PruebaService pruebaService;

    @GetMapping("/allData")
    public ResponseEntity<List<PruebaResponseDto>> getAllData() {
        List<PruebaResponseDto> data = pruebaService.getAllData();
        return ResponseEntity.ok(data);
    }

}
