package com.example.farmacia.infraestructura;

import com.example.farmacia.dominio.Compra;
import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.RepositorioCompra;
import com.example.farmacia.dominio.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepositorioComprarExterno implements RepositorioCompra {

    @Override
    public Compra comprar(Long id, List<Medicamento> listaMedicamento, Usuario usuario, String medioPago, Boolean recetaMedica, Integer cantidad) {
        return null;
    }
}
