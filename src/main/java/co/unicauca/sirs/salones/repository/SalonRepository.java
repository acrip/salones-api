package co.unicauca.sirs.salones.repository;

import co.unicauca.sirs.salones.entity.SalonEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalonRepository extends ListCrudRepository<SalonEntity, Long>{

    //Optional<SalonEntity> findByName(String name);
}
