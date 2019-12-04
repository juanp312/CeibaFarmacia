package com.example.farmacia.aplicacion.fabrica;


import com.example.farmacia.dominio.entidades.Medicamento;
import org.springframework.stereotype.Component;


@Component
    public class FabricaMedicamento {
        public Medicamento crear(String nombre, String codigoMedicamento, Boolean disponibilidad){
        return new Medicamento(nombre,codigoMedicamento, true);
    }


}
