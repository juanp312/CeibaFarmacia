package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.ServicioMedicamento;
import org.springframework.stereotype.Component;

@Component
public class ComprarMedicamento {


    private final FabricaMedicamento fabricaMedicamento;

    public ComprarMedicamento(FabricaMedicamento fabricaMedicamento) {
        this.fabricaMedicamento = fabricaMedicamento;
    }

    public Medicamento realizarCompra(String nombre, String codigoMedicamento){
        Medicamento medicamento = fabricaMedicamento.transaccion(nombre, codigoMedicamento);
        return  medicamento;
    }
}
