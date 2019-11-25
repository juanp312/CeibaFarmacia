package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.Medicamento;
import org.springframework.stereotype.Component;

@Component
    public class FabricaMedicamento {
        public Medicamento crear(String nombre, String codigoMedicamento){
        return new Medicamento(nombre,codigoMedicamento);
    }


    public Medicamento transaccion(String nombre, String codigoMedicamento){
        return new Medicamento(nombre, codigoMedicamento);
    }
}
