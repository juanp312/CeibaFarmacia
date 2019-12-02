package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import org.springframework.stereotype.Component;

@Component
public class RouterValidacionImplementacion implements RouterValidacion {
    private Validacion validacionA = new ValidacionA();
    private Validacion validacionB = new ValidacionB();

    @Override
    public Validacion direccionar(String codigoMedicamento) {
        String primeraLetra =  extraerPrimeraLetra(codigoMedicamento);
        switch (primeraLetra){
            case "A":
                return validacionA;
            case "B":
                return validacionB;
            default:
            throw new RegistroInvalidoException();
        }
    }

    private String extraerPrimeraLetra(String codigoMedicamento) {
        return codigoMedicamento.substring(0,1).toUpperCase();
    }
}
