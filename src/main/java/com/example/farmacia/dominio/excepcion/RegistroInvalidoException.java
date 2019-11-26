package com.example.farmacia.dominio.excepcion;


public class RegistroInvalidoException extends RuntimeException {
    public RegistroInvalidoException() {
    }

    public RegistroInvalidoException(String message) {
        super(message);
    }


}
