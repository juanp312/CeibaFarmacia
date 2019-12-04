package com.example.farmacia.dominio.servicios;


import com.example.farmacia.dominio.entidades.Compra;
import com.example.farmacia.dominio.puertos.RepositorioCompra;
import com.example.farmacia.dominio.puertos.RepositorioMedicamento;
import com.example.farmacia.dominio.excepcion.CompraNoPermitidaException;
import com.example.farmacia.dominio.validacion.RouterValidacionImplementacion;
import com.example.farmacia.dominio.validacion.Validacion;
import org.springframework.stereotype.Component;

@Component
public class ServicioCompra {

    private final RepositorioCompra repositorioCompra;
    private final RepositorioMedicamento repositorioMedicamento;
    private final RouterValidacionImplementacion routerValidacionImplementacion;

    public ServicioCompra(RepositorioCompra repositorioCompra, RepositorioMedicamento repositorioMedicamento, RouterValidacionImplementacion routerValidacionImplementacion) {
        this.repositorioCompra = repositorioCompra;
        this.repositorioMedicamento = repositorioMedicamento;
        this.routerValidacionImplementacion = routerValidacionImplementacion;
    }

    public Compra comprarMedicamento (Compra compra) {
        Integer unidadesDisponibles = repositorioCompra.stockDisponible(compra.getCodigoMedicamento());
        Validacion validacion = routerValidacionImplementacion.direccionar(compra.getCodigoMedicamento());
        if(validacion.validar(compra, unidadesDisponibles)) {
            repositorioMedicamento.actualizarDisponibilidadMedicamento(compra.getCantidad(), compra.getCodigoMedicamento());
            repositorioCompra.crear(compra);
        } else {
            throw new CompraNoPermitidaException("La validacion de compras ha fallado");
        }
        return compra;
    }

}
