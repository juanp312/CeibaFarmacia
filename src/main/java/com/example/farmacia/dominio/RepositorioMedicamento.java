package com.example.farmacia.dominio;

public interface RepositorioMedicamento {

    Medicamento adicionarMedicamento (Medicamento medicamento);
    void eliminarMedicamento(String codigoMedicamento);
    }

