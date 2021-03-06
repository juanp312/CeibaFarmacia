package com.example.farmacia.dominio.servicios;

import com.example.farmacia.dominio.entidades.Medicamento;
import com.example.farmacia.dominio.puertos.RepositorioMedicamento;
import com.example.farmacia.dominio.excepcion.RegistroNoEncontradoException;
import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class ServicioMedicamento {

    private final RepositorioMedicamento repositorioMedicamento;


    public ServicioMedicamento(RepositorioMedicamento repositorioMedicamento) {
        this.repositorioMedicamento = repositorioMedicamento;
    }

    public Medicamento adicionarMedicamento(Medicamento medicamento) {
        if (medicamento.getCodigoMedicamento().toUpperCase().startsWith("A") ||
                medicamento.getCodigoMedicamento().toUpperCase().startsWith("B")) {
            return repositorioMedicamento.crear(medicamento);
        }
        throw new RegistroInvalidoException("No se pueden agregar medicamentos de este tipo");
    }

    public void eliminarMedicamento(Integer id) {
        try {
            repositorioMedicamento.eliminar(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RegistroNoEncontradoException(e, "No se encontro registro para el Id solicitado");
        }

    }
}
