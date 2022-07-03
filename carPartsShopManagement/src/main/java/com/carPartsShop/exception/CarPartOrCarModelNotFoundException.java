package com.carPartsShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car Part or Car Model Not found")
public class CarPartOrCarModelNotFoundException extends RuntimeException {
}
