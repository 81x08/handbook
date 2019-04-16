package ru.ras.handbook.service;

import ru.ras.handbook.model.CarEntity;

import java.util.List;

public interface ICarService {

    List<CarEntity> getCars();

    CarEntity add(CarEntity carEntity);

    void delete(Long id);

}
