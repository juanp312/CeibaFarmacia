package com.example.farmacia.infraestructura.dto;


import javax.validation.constraints.NotNull;

public class MedicamentoDto {



    @NotNull
    private String nombreMedicamento;

    @NotNull
    private String codigoMedicamento;

    @NotNull
    private Boolean disponibilidad;

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }
}
