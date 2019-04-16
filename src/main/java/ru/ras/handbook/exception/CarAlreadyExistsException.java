package ru.ras.handbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Car already exists")
public class CarAlreadyExistsException extends RuntimeException {
}
