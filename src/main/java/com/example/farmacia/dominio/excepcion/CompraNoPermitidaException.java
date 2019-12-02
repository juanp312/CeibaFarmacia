package com.example.farmacia.dominio.excepcion;

public class CompraNoPermitidaException extends RuntimeException {

    public CompraNoPermitidaException() {
    }

    public CompraNoPermitidaException(String message) {
        super(message);
    }
}
