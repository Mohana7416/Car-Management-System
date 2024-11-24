package com.Spyne.Car_Management_Application.CarUtilites;

import com.Spyne.Car_Management_Application.Model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Carutilites {
    private Carutilites(){

    }
    public static ResponseEntity<String> getMessage(String message, HttpStatus internalServer)
    {
        return new ResponseEntity<String>(message,internalServer);
    }



}
