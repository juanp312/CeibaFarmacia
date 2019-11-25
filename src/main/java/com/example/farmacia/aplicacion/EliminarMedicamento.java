package com.example.farmacia.aplicacion;

import com.example.farmacia.infraestructura.Repositorio;

public class EliminarMedicamento {

    private final Repositorio repositorioMedicamento;

    public EliminarMedicamento(Repositorio repositorioMedicamento) {
        this.repositorioMedicamento = repositorioMedicamento;
    }

    public void borrar(String codigoMedicamento){
        repositorioMedicamento.deleteById(codigoMedicamento);
    }
}
