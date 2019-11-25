package com.example.farmacia.dominio;


import com.example.farmacia.aplicacion.Repositorio;

public class ServicioMedicamento implements  RepositorioMedicamento {

    private final RepositorioMedicamento repositorioMedicamento;

    public ServicioMedicamento(RepositorioMedicamento repositorioMedicamento) {
        this.repositorioMedicamento = repositorioMedicamento;
    }

    //todo validacion agregar Medicamento
    public Medicamento adicionarMedicamento(Medicamento medicamento){
    return medicamento;
    }

    //todo validacion eliminar medicamento

    public void eliminarMedicamento (String codigoMedicamento){

    }
}
