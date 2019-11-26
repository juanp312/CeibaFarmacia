package com.example.farmacia.dominio;

import com.example.farmacia.dominio.excepcion.RegistroNoEncontradoException;
import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServicioMedicamento {

    private final RepositorioMedicamento repositorioMedicamento;
    private final RepositorioComprar repositorioComprar;


    public ServicioMedicamento(RepositorioMedicamento repositorioMedicamento, RepositorioComprar repositorioComprar) {
        this.repositorioMedicamento = repositorioMedicamento;
        this.repositorioComprar = repositorioComprar;
    }


    //todo validacion agregar Medicamento
    public Medicamento adicionarMedicamento(Medicamento medicamento) {
        if (medicamento.getNombreMedicamento().toUpperCase().startsWith("A") ||
                medicamento.getNombreMedicamento().toUpperCase().startsWith("B")) {
            return repositorioMedicamento.crearMedicamento(medicamento);
        }
        throw new RegistroInvalidoException("No se pueden agregar medicamentos de este tipo");
    }

    //todo validacion eliminar medicamento
    public void eliminarMedicamento(String codigoMedicamento) {
        try {
            repositorioMedicamento.eliminarMedicamento(codigoMedicamento);
        } catch (EmptyResultDataAccessException e) {
            throw new RegistroNoEncontradoException("No se encontro registro");
        }
    }

    //todo validacion traerMedicamentos
    public List<Medicamento> listaMedicamentos(){
        return repositorioMedicamento.retornarMedicamentos().stream()
                                     .collect(Collectors.toList());
    }
    //todo validacion para comprar
    public void comprarMedicamento () {



    }
}
