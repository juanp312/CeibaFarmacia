package com.example.farmacia.dominio.puertos;

import com.example.farmacia.dominio.entidades.Compra;

import java.util.List;

public interface RepositorioCompra {

    Compra crear(Compra compra);

    Integer stockDisponible(String codigoMedicamento);

    List<Compra> retornar();
}
