package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.ServicioMedicamento;
import org.springframework.stereotype.Component;

@Component
public class AgregarMedicamento {


    private final FabricaMedicamento fabricaMedicamento;

    public AgregarMedicamento(FabricaMedicamento fabricaMedicamento) {
        this.fabricaMedicamento = fabricaMedicamento;

    }

    public Medicamento ejecutar (String nombre, String codigoMedicamento){
        Medicamento medicamento = fabricaMedicamento.crear(nombre, codigoMedicamento);
        return medicamento;
    }

}
