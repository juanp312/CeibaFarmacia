package com.example.farmacia.dominio;

import com.example.farmacia.dominio.excepcion.RegistroNoEncontradoException;
import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import org.apache.tomcat.jni.Local;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ServicioMedicamento {

    private final RepositorioMedicamento repositorioMedicamento;
    private final RepositorioComprar repositorioComprar;


    public ServicioMedicamento(RepositorioMedicamento repositorioMedicamento, RepositorioComprar repositorioComprar) {
        this.repositorioMedicamento = repositorioMedicamento;
        this.repositorioComprar = repositorioComprar;
    }


    //todo validacion agregar Medicamento
    public Medicamento adicionarMedicamento(Medicamento medicamento) {
        if (medicamento.getNombreMedicamento().toUpperCase().startsWith("A") ||
                medicamento.getNombreMedicamento().toUpperCase().startsWith("B")) {
            return repositorioMedicamento.crear(medicamento);
        }
        throw new RegistroInvalidoException("No se pueden agregar medicamentos de este tipo");
    }

    //todo validacion eliminar medicamento
    public void eliminarMedicamento(String codigoMedicamento) {
        Medicamento medicamento;
        Optional<Medicamento> medicamentoRetornado = repositorioMedicamento.retornarPorId(codigoMedicamento);
        Optional<Medicamento> medicamentoRetornado = Optional.of(repositorioMedicamento.retornarPorId(codigoMedicamento));
        if ( noExisteMedicamentoDisponible(medicamentoRetornado)){
            throw new RegistroNoEncontradoException("No existe el medicamento " + codigoMedicamento);
        }
        medicamento = medicamentoRetornado.get();
        Integer cantidadActualStock = medicamento.getStock().getCantidadDisponible();
        medicamento.getStock().setCantidadDisponible(cantidadActualStock - 1);
        repositorioMedicamento.crear(medicamento);
    }

    //todo validacion traerMedicamentos
    public List<Medicamento> listaMedicamentos(){
        return repositorioMedicamento.retornar().stream()
                                     .collect(Collectors.toList());
    }
    //todo validacion para comprar
    public void comprarMedicamento (String codigoMedicamento) {
        Medicamento medicamento;
        Compra compra = new Compra();
        Boolean medioPago = compra.getMedioDePago();
        Boolean receta = compra.getRecetaMedica();
        if(medioPago){
        }
        Optional<Medicamento> medicamentoRetornado = Optional.of(repositorioMedicamento.retornarPorId(codigoMedicamento));
        if ( noExisteMedicamentoDisponible(medicamentoRetornado)){
            throw new RegistroNoEncontradoException("No existe el medicamento " + codigoMedicamento);
        }
        medicamento = medicamentoRetornado.get();
        LocalDate fechaCompra = LocalDate.now();
        Integer cantidadDisponibleActual = medicamento.getStock().getCantidadDisponible();
        Integer cantidadVendidaActual = medicamento.getStock().getCantidadVendida();
        medicamento.getStock().setCantidadDisponible(cantidadDisponibleActual - 1);
        medicamento.getStock().setCantidadVendida(cantidadVendidaActual + 1);
        medicamento.getStock().getCompras().add(crearCompra(fechaCompra));

    }

    private boolean noExisteMedicamentoDisponible(Optional<Medicamento> medicamentoRetornado){
        if(!medicamentoRetornado.isPresent()){
            return true;
        }
        if(medicamentoRetornado.get().getStock().getCantidadDisponible() == Integer.valueOf(0)){
            return  true;
        }
        return false;
    }

    private Compra crearCompra(LocalDate fecha){
        Compra compra = new Compra();
        compra.setFecha(LocalDate.now());
        return compra;
    }
}
