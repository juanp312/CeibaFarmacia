package com.example.farmacia.dominio;

import java.util.List;

public interface RepositorioCompra {

    Compra crear(Compra compra);

    Integer stockDisponible(String codigoMedicamento);

    List<Compra> retornar();
}
