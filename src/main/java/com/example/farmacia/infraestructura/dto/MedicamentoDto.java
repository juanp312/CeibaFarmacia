package com.example.farmacia.infraestructura.dto;


import javax.validation.constraints.NotNull;

public class MedicamentoDto {



    @NotNull
    private String nombreMedicamento;

    @NotNull
    private String codigoMedicamento;

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }
}
