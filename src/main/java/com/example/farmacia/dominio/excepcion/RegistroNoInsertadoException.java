package com.example.farmacia.dominio.excepcion;


public class RegistroNoInsertadoException extends RuntimeException {
    public RegistroNoInsertadoException() {
    }

    public RegistroNoInsertadoException(String message) {
        super(message);
    }


}
