package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.Compra;
import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.MedioPagoEnum;

public class ValidacionA implements Validacion {

    @Override
    public Boolean validar(Compra compra, Integer unidadesDisponibles) {
        if (compra.getMedioPago().equals(MedioPagoEnum.TARJETA.getTipoPago())) {
            return false;
        }

        if (compra.getCantidad() > 3){
            return false;
        }

        if (compra.getCantidad() > unidadesDisponibles){
            return false;
        }
        return true;
    }
}