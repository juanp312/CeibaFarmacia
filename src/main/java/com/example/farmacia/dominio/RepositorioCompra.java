package com.example.farmacia.dominio;

import java.util.List;

public interface RepositorioCompra {

    Compra comprar(Long id, List<Medicamento> listaMedicamento, Usuario usuario,
                   String medioPago, Boolean recetaMedica, Integer cantidad);
}
