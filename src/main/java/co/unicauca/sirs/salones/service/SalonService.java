package co.unicauca.sirs.salones.service;

import co.unicauca.sirs.salones.entity.SalonEntity;
import co.unicauca.sirs.salones.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;

    public List<SalonEntity> obtenerTodosLosSalones() {
        return salonRepository.findAll();
    }

    public SalonEntity obtenerSalonPorId(Long id) {
        return salonRepository.findById(id).orElseThrow();
    }

    public SalonEntity crearSalon(SalonEntity salon) {
        return salonRepository.save(salon);
    }

    public void actualizarSalon(SalonEntity salonEntity) { salonRepository.save(salonEntity); }

    public void eliminarSalon(Long id) { salonRepository.deleteById(id); }
}
