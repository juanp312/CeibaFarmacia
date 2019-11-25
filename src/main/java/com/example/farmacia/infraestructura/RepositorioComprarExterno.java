package com.example.farmacia.infraestructura;

import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.RepositorioComprar;

public class RepositorioComprarExterno implements RepositorioComprar {

    @Override
    public Medicamento comprarMedicamento(String nombre, String codigoMedicamento) {
        return null;
    }
}
