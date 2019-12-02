package com.example.farmacia.dominio;

public enum MedioPagoEnum {
    EFECTIVO("efectivo"),
    TARJETA("tarjeta");

    private String tipoPago;

    private MedioPagoEnum(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }
}
