package com.example.farmacia.dominio;

import java.util.List;

public class Compra {

    private List <Medicamento> listaMedicamento;
    private Usuario usuario;
    private String medioDePago;
    private Boolean recetaMedica;

    public Compra(List<Medicamento> listaMedicamento, Usuario usuario, String medioDePago, Boolean recetaMedica) {
        this.listaMedicamento = listaMedicamento;
        this.usuario = usuario;
        this.medioDePago = medioDePago;
        this.recetaMedica = recetaMedica;
    }

    public List<Medicamento> getListaMedicamento() {
        return listaMedicamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public Boolean getRecetaMedica() {
        return recetaMedica;
    }
}
