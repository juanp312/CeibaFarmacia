package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.entidades.Compra;

public class ValidacionA implements Validacion {

    @Override
    public Boolean validar(Compra compra, Integer unidadesDisponibles) {
        if (compra.getMedioPago().equals(MedioPagoEnum.TARJETA.getTipoPago())) {
            return false;
        }

        if (compra.getCantidad() > 3){
            return false;
        }

        return compra.getCantidad() <= unidadesDisponibles;
    }
}