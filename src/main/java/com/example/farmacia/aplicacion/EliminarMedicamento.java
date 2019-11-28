package com.example.farmacia.aplicacion;

import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.RepositorioMedicamento;
import org.springframework.stereotype.Component;

@Component
public class EliminarMedicamento {

    private final RepositorioMedicamento repositorio;

    public EliminarMedicamento(RepositorioMedicamento repositorio) {
        this.repositorio = repositorio;
    }

    public void borrar(String codigoMedicamento){
        repositorio.eliminar(codigoMedicamento);
    }
}
