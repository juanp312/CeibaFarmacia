package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.ServicioMedicamento;

import java.util.List;

public class MedicamentoDisponible {

    private final ServicioMedicamento servicioMedicamento;
    private final FabricaMedicamento fabricaMedicamento;
    private final Repositorio repositorio;

    public MedicamentoDisponible(ServicioMedicamento servicioMedicamento, FabricaMedicamento fabricaMedicamento, Repositorio repositorio) {
        this.servicioMedicamento = servicioMedicamento;
        this.fabricaMedicamento = fabricaMedicamento;
        this.repositorio = repositorio;
    }

    public List<Medicamento> consultar(){
        List<Medicamento> listaMedicamento = repositorio.findAll();
        return  listaMedicamento;
    }
}
