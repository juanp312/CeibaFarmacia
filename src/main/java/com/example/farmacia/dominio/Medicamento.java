package com.example.farmacia.dominio;

public final class Medicamento {

    private String nombreMedicamento;
    private String codigoMedicamento;
    private Stock stock;

    public Medicamento(String nombreMedicamento, String codigoMedicamento, Stock stock) {
        this.nombreMedicamento = nombreMedicamento;
        this.codigoMedicamento = codigoMedicamento;
        this.stock = stock;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public Stock getStock() {
        return stock;
    }
}
