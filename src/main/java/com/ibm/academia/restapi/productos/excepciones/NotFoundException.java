package com.ibm.academia.restapi.productos.excepciones;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
