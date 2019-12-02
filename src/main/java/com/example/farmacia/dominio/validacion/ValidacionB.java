package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.Compra;

public class ValidacionB implements Validacion {


    @Override
    public Boolean validar(Compra compra, Integer unidadesDisponibles) {
        if(compra.getRecetaMedica().equals(false)){
            return false;
        }
        return true;
    }
}
