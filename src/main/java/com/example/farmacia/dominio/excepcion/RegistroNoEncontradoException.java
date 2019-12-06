package com.example.farmacia.dominio.excepcion;


import org.springframework.dao.EmptyResultDataAccessException;

public class RegistroNoEncontradoException extends RuntimeException {
    public RegistroNoEncontradoException() {
    }

    public RegistroNoEncontradoException(String message) {
        super(message);
    }

    public RegistroNoEncontradoException(EmptyResultDataAccessException e, String s) {

    }
}

