package co.unicauca.sirs.salones.controller;

import co.unicauca.sirs.salones.controller.mapper.SalonDTO;
import co.unicauca.sirs.salones.controller.mapper.SalonMapper;
import co.unicauca.sirs.salones.controller.request.SalonRequestDTO;
import co.unicauca.sirs.salones.entity.SalonEntity;
import co.unicauca.sirs.salones.service.SalonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/salones", produces = MediaType.APPLICATION_JSON_VALUE)
public class SalonController {
    @Autowired
    private SalonService salonService;

    @Autowired
    private SalonMapper salonMapper;

    @GetMapping
    public ResponseEntity<List<SalonDTO>> obtenerTodosLosSalones() {
        return ResponseEntity.ok(salonMapper.toDtos(salonService.obtenerTodosLosSalones()));
        //TODO: Manage exceptions
        //TODO: Llevar la logica a la capa de servicio
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalonDTO> obtenerSalonPorId(@PathVariable Long id) {
        return ResponseEntity.ok(salonMapper.toDto(salonService.obtenerSalonPorId(id)));
        //TODO: Manage exceptions
        //TODO: Llevar la logica a la capa de servicio
    }

    @PostMapping
    public ResponseEntity<SalonDTO> crearSalon(@RequestBody @Valid SalonRequestDTO salonRequestDTO) throws URISyntaxException {
        SalonEntity salonEntity = salonService.crearSalon(salonMapper.toEntity(salonRequestDTO));
        SalonDTO salonDto = salonMapper.toDto(salonEntity);
        return ResponseEntity.created(new URI("salones/" + salonDto.id())).body(salonDto);
        //TODO: Manage exceptions
        //TODO: Llevar la logica a la capa de servicio
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalonDTO> actualizarSalon(@PathVariable Long id, @RequestBody @Valid SalonRequestDTO salonRequestDTO) {
        SalonEntity salonEntity = salonMapper.toEntity(salonRequestDTO);
        salonEntity.setId(id);
        salonService.actualizarSalon(salonEntity);
        SalonDTO salonDto = salonMapper.toDto(salonEntity);
        return ResponseEntity.ok(salonDto);
        //TODO: Manage exceptions
        //TODO: Llevar la logica a la capa de servicio
        //TODO: Verificar URI
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSalon(@PathVariable Long id) {
        salonService.eliminarSalon(id);
        return ResponseEntity.noContent().build();
        //TODO: Manage exceptions
        //TODO: Llevar la logica a la capa de servicio
        //TODO: Is this ok?
    }
}
