package com.example.farmacia.dominio;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ServicioMedicamento{

    private final RepositorioMedicamento repositorioMedicamento;
    private final RepositorioComprar repositorioComprar;

    public ServicioMedicamento(RepositorioMedicamento repositorioMedicamento, RepositorioComprar repositorioComprar) {
        this.repositorioMedicamento = repositorioMedicamento;
        this.repositorioComprar = repositorioComprar;
    }

    //todo validacion agregar Medicamento
    public Medicamento adicionarMedicamento(Medicamento medicamento){

    return medicamento;
    }

    //todo validacion eliminar medicamento
    public void eliminarMedicamento (String codigoMedicamento){

    }

    //todo validacion para comprar
    public void comprarMedicamento(){

    }
}
