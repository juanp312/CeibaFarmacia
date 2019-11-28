package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.RepositorioMedicamento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicamentoDisponible {

    private final RepositorioMedicamento repositorio;

    public MedicamentoDisponible(RepositorioMedicamento repositorio) {
        this.repositorio = repositorio;
    }

    public List<Medicamento> consultar(){
        List<Medicamento> listaMedicamento = repositorio.retornar();
        return  listaMedicamento;
    }
}
