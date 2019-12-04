package com.example.farmacia.dominio;

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
        if (medicamento.getNombreMedicamento().toUpperCase().startsWith("A") ||
                medicamento.getNombreMedicamento().toUpperCase().startsWith("B")) {
            return repositorioMedicamento.crear(medicamento);
        }
        throw new RegistroInvalidoException("No se pueden agregar medicamentos de este tipo");
    }

    public void eliminarMedicamento(Integer id) {
        try {
            repositorioMedicamento.eliminar(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RegistroNoEncontradoException("No se encontro registro para el Id solicitado");
        }

    }
}
