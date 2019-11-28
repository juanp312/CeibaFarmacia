package com.example.farmacia.dominio;


import java.time.LocalDate;
import java.util.List;

public class Compra {

    private Long id;
    private List<Medicamento> listaMedicamento;
    private Usuario usuario;
    private Boolean medioDePago;
    private Boolean recetaMedica;
    private LocalDate fecha;

    public Compra(Long id, List<Medicamento> listaMedicamento, Usuario usuario, Boolean medioDePago, Boolean recetaMedica, LocalDate fecha) {
        this.id = id;
        this.listaMedicamento = listaMedicamento;
        this.usuario = usuario;
        this.medioDePago = medioDePago;
        this.recetaMedica = recetaMedica;
        this.fecha = fecha;
    }

    public Compra() {

    }

    public Long getId() {
        return id;
    }

    public List<Medicamento> getListaMedicamento() {
        return listaMedicamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Boolean getMedioDePago() {
        return medioDePago;
    }

    public Boolean getRecetaMedica() {
        return recetaMedica;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public final void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}