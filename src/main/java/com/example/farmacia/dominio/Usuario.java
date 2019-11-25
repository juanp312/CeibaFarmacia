package com.example.farmacia.dominio;


public final class Usuario {

    private Long numeroIdentidad;
    private String nombre;
    private Integer edad;

    public Usuario(Long numeroIdentidad, String nombre, Integer edad) {
        this.numeroIdentidad = numeroIdentidad;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Long getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }
}
