package com.example.farmacia.infraestructura.dto;


import javax.validation.constraints.NotNull;

public class MedicamentoDto {

    @NotNull
    private String nombre;

    @NotNull
    private String codigoMedicamento;

    public String getNombre() {
        return nombre;
    }

    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }
}
