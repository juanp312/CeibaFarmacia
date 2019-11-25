package com.example.farmacia.aplicacion;

import com.example.farmacia.dominio.ServicioMedicamento;

public class EliminarMedicamento {

    private final ServicioMedicamento servicioMedicamento;
    private final Repositorio repositorioMedicamento;

    public EliminarMedicamento(ServicioMedicamento servicioMedicamento, Repositorio repositorioMedicamento) {
        this.servicioMedicamento = servicioMedicamento;
        this.repositorioMedicamento = repositorioMedicamento;
    }

    public void borrar(String codigoMedicamento){
        repositorioMedicamento.deleteById(codigoMedicamento);
    }
}
