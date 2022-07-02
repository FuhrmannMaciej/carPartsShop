package com.carPartsShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car Model Not found")
public class CarModelNotFoundException extends RuntimeException{
}
