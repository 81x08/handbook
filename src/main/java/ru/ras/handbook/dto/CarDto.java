package ru.ras.handbook.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CarDto {

    private Long id;
    private String brand;
    private String model;
    private Date released;

}
