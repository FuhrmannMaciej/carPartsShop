package com.carPartsShopManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car Part Not found")
public class CarPartNotFoundException extends RuntimeException {
}
