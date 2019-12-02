package com.example.farmacia.aplicacion;

import com.example.farmacia.dominio.Compra;
import com.example.farmacia.dominio.RepositorioCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComprasHechas {

    private final RepositorioCompra repositorioCompra;

    public ComprasHechas(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public List<Compra> consultar(){
        List<Compra> listaCompras = repositorioCompra.retornar();
        return  listaCompras;
    }
}
