package com.example.farmacia.aplicacion;

import com.example.farmacia.dominio.entidades.Compra;
import com.example.farmacia.dominio.puertos.RepositorioCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComprasHechas {

    private final RepositorioCompra repositorioCompra;

    public ComprasHechas(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public List<Compra> consultar(){
        return repositorioCompra.retornar();
    }
}
