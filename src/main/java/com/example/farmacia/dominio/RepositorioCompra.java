package com.example.farmacia.dominio;

public interface RepositorioCompra {

    Compra crear(Compra compra);

    Integer stockDisponible(String codigoMedicamento);

}
