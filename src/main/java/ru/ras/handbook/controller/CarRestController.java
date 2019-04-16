package ru.ras.handbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.ras.handbook.dto.CarDto;
import ru.ras.handbook.model.CarEntity;
import ru.ras.handbook.service.ICarService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {

    private ICarService carService;

    @Autowired
    public CarRestController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping
    @ResponseBody
    public List<CarDto> list() {
        List<CarEntity> carEntities = carService.getCars();

        return carEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK, reason = "Car added successfully")
    public void add(@RequestBody CarDto carDto) {
        carService.add(convertToEntity(carDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Car deleted successfully")
    public void delete(@PathVariable("id") Long id) {
        carService.delete(id);
    }

    private CarEntity convertToEntity(CarDto carDto) {
        CarEntity carEntity = new CarEntity();

        carEntity.setBrand(carDto.getBrand());
        carEntity.setModel(carDto.getModel());
        carEntity.setReleased(carDto.getReleased());

        return carEntity;
    }

    private CarDto convertToDto(CarEntity carEntity) {
        CarDto carDto = new CarDto();

        carDto.setId(carEntity.getId());
        carDto.setBrand(carEntity.getBrand());
        carDto.setModel(carEntity.getModel());
        carDto.setReleased(carEntity.getReleased());

        return carDto;
    }

}
