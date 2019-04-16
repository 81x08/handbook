package ru.ras.handbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Car not found")
public class CarNotFoundException extends RuntimeException{
}
