package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;

public class RouterValidacionImplementacion implements RouterValidacion {
    private Validacion validacionA = new ValidacionA();
    private Validacion validacionB = new ValidacionB();

    @Override
    public Validacion direccionar(String codigoMedicamento) {
        switch (codigoMedicamento){
            case "A":
                return validacionA;
            case "B":
                return validacionB;
            default:
            throw new RegistroInvalidoException();
        }
    }
}
