package com.example.farmacia.dominio;

import com.example.farmacia.dominio.excepcion.RegistroNoEncontradoException;
import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ServicioMedicamento {

    private final RepositorioMedicamento repositorioMedicamento;
    private final RepositorioCompra repositorioComprar;


    public ServicioMedicamento(RepositorioMedicamento repositorioMedicamento, RepositorioCompra repositorioComprar) {
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
       //  Optional<Medicamento> medicamentoRetornado = repositorioMedicamento.retornarPorId(codigoMedicamento);


        //Optional<Medicamento> medicamentoRetornado = repositorioMedicamento.retornarPorId(codigoMedicamento);

        Optional<Medicamento> medicamentoRetornado = Optional.of(repositorioMedicamento.retornarPorId(codigoMedicamento));
        if (noExisteMedicamentoDisponible(medicamentoRetornado)) {
            throw new RegistroNoEncontradoException("No existe el medicamento " + codigoMedicamento);
        }
        medicamento = medicamentoRetornado.get();
        // Integer cantidadActualStock = medicamento.getStock().getCantidadDisponible();
//        medicamento.getStock().setCantidadDisponible(cantidadActualStock - 1);
        repositorioMedicamento.crear(medicamento);
    }

    //todo validacion traerMedicamentos
    public List<Medicamento> listaMedicamentos() {
        return repositorioMedicamento.retornar().stream()
                .collect(Collectors.toList());
    }


    private boolean noExisteMedicamentoDisponible(Optional<Medicamento> medicamentoRetornado){
        if(!medicamentoRetornado.isPresent()){
            return true;
        }
//        if(medicamentoRetornado.get().getStock().getCantidadDisponible() == Integer.valueOf(0)){
//            return  true;
//        }
        return false;
    }
}