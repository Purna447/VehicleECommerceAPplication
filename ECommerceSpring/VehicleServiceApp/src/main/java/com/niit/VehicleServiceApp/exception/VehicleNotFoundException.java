package com.niit.VehicleServiceApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "User does not exists")
public class VehicleNotFoundException extends Exception{
}