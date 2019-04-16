package ru.ras.handbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ras.handbook.exception.CarAlreadyExistsException;
import ru.ras.handbook.exception.CarNotFoundException;
import ru.ras.handbook.model.CarEntity;
import ru.ras.handbook.repository.CarRepository;
import ru.ras.handbook.service.ICarService;

import java.util.Date;
import java.util.List;

@Service
public class CarService implements ICarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarEntity> getCars() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity add(CarEntity carEntity) {
        CarEntity carExists = isCarExists(carEntity);

        if (carExists == null) {
            return carRepository.save(carEntity);
        }

        throw new CarAlreadyExistsException();
    }

    @Override
    public void delete(Long id) {
        boolean exists = carRepository.existsById(id);

        if (exists) {
            carRepository.deleteById(id);
        } else {
            throw new CarNotFoundException();
        }
    }

    private CarEntity isCarExists(CarEntity carEntity) {
        String brand = carEntity.getBrand();
        String model = carEntity.getModel();
        Date released = carEntity.getReleased();

        return carRepository.findByBrandAndModelAndReleased(brand, model, released);
    }

}
