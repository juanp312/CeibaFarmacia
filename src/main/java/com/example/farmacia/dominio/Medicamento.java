package com.example.farmacia.dominio;

public final class Medicamento {

    private String nombreMedicamento;
    private String codigoMedicamento;
    private Boolean disponibilidad;

    public Medicamento(String nombreMedicamento, String codigoMedicamento, Boolean disponibilidad) {
        this.nombreMedicamento = nombreMedicamento;
        this.codigoMedicamento = codigoMedicamento;
        this.disponibilidad = disponibilidad;

    }

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
