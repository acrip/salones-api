package co.unicauca.sirs.salones.controller.mapper;

import co.unicauca.sirs.salones.controller.request.SalonRequestDTO;
import co.unicauca.sirs.salones.entity.SalonEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SalonMapper {
    SalonDTO toDto(SalonEntity salonEntity);

    SalonEntity toEntity(SalonDTO salonDto);

    SalonEntity toEntity(SalonRequestDTO salonRequestDTO);

    List<SalonDTO> toDtos(List<SalonEntity> salonEntities);
}