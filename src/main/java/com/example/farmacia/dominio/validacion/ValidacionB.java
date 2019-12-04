package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.entidades.Compra;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ValidacionB implements Validacion {
    DayOfWeek domingo = DayOfWeek.SUNDAY;

    @Override
    public Boolean validar(Compra compra, Integer unidadesDisponibles) {
        if(compra.getRecetaMedica().equals(false)){
            return false;
        }

        if(compra.getMedioPago().equals(MedioPagoEnum.EFECTIVO.getTipoPago())){
            return false;
        }

        if(compra.getEdad() < 18) {
            return false;
        }

        if(compra.getCantidad() > unidadesDisponibles){
            return false;
        }

        if(LocalDate.now().getDayOfWeek().equals(domingo) &&
                (compra.getMedioPago().equals(MedioPagoEnum.TARJETA.getTipoPago()))){
            return false;
        }

        return true;
    }
}
