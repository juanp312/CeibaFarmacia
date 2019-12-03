package com.example.farmacia.infraestructura.dto;


import javax.validation.constraints.NotNull;

public class ComprarDto {

    @NotNull
    private String codigoMedicamento;

    @NotNull
    private Long numeroIdentidad;

    @NotNull
    private Integer edad;

    @NotNull
    private String medioPago;

    @NotNull
    private Boolean recetaMedica;

    @NotNull
    private Integer cantidad;


    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public Long getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public Boolean getRecetaMedica() {
        return recetaMedica;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
