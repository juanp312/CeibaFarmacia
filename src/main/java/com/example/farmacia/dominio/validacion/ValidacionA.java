package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.Compra;
import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.validacion.Validacion;

public class ValidacionA implements Validacion {
    private Compra compra;

    @Override
    public Validacion validar(String codigoMedicamento) {
        if(codigoMedicamento.startsWith("A")){
        compra.getMedioPago();
        compra.getRecetaMedica();
        }
        return null;
    }
}