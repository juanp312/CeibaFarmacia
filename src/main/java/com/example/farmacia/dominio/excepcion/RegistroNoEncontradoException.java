package com.example.farmacia.dominio.excepcion;


public class RegistroNoEncontradoException extends RuntimeException {
    public RegistroNoEncontradoException() {
    }

    public RegistroNoEncontradoException(String message) {
        super(message);
    }

    }

