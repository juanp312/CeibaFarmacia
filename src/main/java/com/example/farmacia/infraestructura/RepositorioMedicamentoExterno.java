package com.example.farmacia.infraestructura;

import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.RepositorioMedicamento;

public class RepositorioMedicamentoExterno implements RepositorioMedicamento {

    @Override
    public Medicamento adicionarMedicamento(Medicamento medicamento) {
        return null;
    }

    @Override
    public void eliminarMedicamento(String codigoMedicamento) {

    }
}
