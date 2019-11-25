package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.ServicioMedicamento;


public class AgregarMedicamento {

    private final ServicioMedicamento servicioMedicamento;
    private final FabricaMedicamento fabricaMedicamento;

    public AgregarMedicamento(ServicioMedicamento servicioMedicamento, FabricaMedicamento fabricaMedicamento) {
        this.servicioMedicamento = servicioMedicamento;
        this.fabricaMedicamento = fabricaMedicamento;

    }

    public Medicamento ejecutar (String nombre, String codigoMedicamento){
        Medicamento medicamento = fabricaMedicamento.crear(nombre, codigoMedicamento);
        return medicamento;
    }

}
