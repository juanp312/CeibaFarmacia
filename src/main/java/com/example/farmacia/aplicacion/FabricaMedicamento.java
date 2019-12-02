package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.Compra;
import com.example.farmacia.dominio.Medicamento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
    public class FabricaMedicamento {
        public Medicamento crear(String nombre, String codigoMedicamento, Boolean disponibilidad){
        return new Medicamento(nombre,codigoMedicamento, true);
    }


}
