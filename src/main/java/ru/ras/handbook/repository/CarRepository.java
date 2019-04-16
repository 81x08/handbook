package ru.ras.handbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ras.handbook.model.CarEntity;

import java.util.Date;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    CarEntity findByBrandAndModelAndReleased(String brand, String model, Date released);

}
