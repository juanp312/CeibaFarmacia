package com.example.farmacia.dominio;


public final class Medicamento {

    private String nombreMedicamento;
    private String codigoMedicamento;

    public Medicamento(String nombreMedicamento, String codigoMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
        this.codigoMedicamento = codigoMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }
}
