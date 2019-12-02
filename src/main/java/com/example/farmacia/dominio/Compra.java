package com.example.farmacia.dominio;


import java.time.LocalDate;

public class Compra {

    private String codigoMedicamento;
    private Long numeroIdentidad;
    private Integer edad;
    private String medioPago;
    private Boolean recetaMedica;
    private Integer cantidad;
    private LocalDate fecha;

    public Compra(){

    }

    public Compra(String codigoMedicamento, Long numeroIdentidad, Integer edad, String medioPago, Boolean recetaMedica, Integer cantidad) {
        this.codigoMedicamento = codigoMedicamento;
        this.numeroIdentidad = numeroIdentidad;
        this.edad = edad;
        this.medioPago = medioPago;
        this.recetaMedica = recetaMedica;
        this.cantidad = cantidad;
        this.fecha = LocalDate.now();
    }

    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public Long getNumeroIdentidad() {
        return numeroIdentidad;
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

    public Integer getEdad() {
        return edad;
    }
}