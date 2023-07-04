package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.service.PruebaService;
import com.nasa.prueba.aspirante.infraestructura.clientrest.PruebaClienteRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class PruebaTask {
    private final PruebaClienteRest clienteRest;
    private final PruebaService pruebaService;

    @Scheduled(fixedRate = 60000)
    public void scheduledNasaImages() {

        List<PruebaDto> data = clienteRest.searchNasaImages();

        pruebaService.saveData(data);
        log.info("DATOS PROCESADOS: "+data.size());

    }
}
