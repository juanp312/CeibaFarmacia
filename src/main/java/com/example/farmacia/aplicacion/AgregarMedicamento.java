package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.ServicioMedicamento;
import org.springframework.stereotype.Component;

@Component
public class AgregarMedicamento {


    private final FabricaMedicamento fabricaMedicamento;
    private final ServicioMedicamento servicioMedicamento;

    public AgregarMedicamento(FabricaMedicamento fabricaMedicamento, ServicioMedicamento servicioMedicamento) {
        this.fabricaMedicamento = fabricaMedicamento;
        this.servicioMedicamento = servicioMedicamento;
    }

    public Medicamento ejecutar (String nombre, String codigoMedicamento){
        Medicamento medicamento = fabricaMedicamento.crear(nombre, codigoMedicamento);
        return servicioMedicamento.adicionarMedicamento(medicamento);
    }

}
