package com.example.farmacia.infraestructura;

import com.example.farmacia.aplicacion.AgregarMedicamento;
import com.example.farmacia.aplicacion.ComprarMedicamento;
import com.example.farmacia.aplicacion.EliminarMedicamento;
import com.example.farmacia.aplicacion.MedicamentoDisponible;
import com.example.farmacia.dominio.Compra;
import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.infraestructura.dto.ComprarDto;
import com.example.farmacia.infraestructura.dto.MedicamentoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControladorMedicamento {

    private final AgregarMedicamento agregarMedicamento;
    private final EliminarMedicamento eliminarMedicamento;
    private final ComprarMedicamento comprarMedicamento;
    private final MedicamentoDisponible medicamentoDisponible;

    public ControladorMedicamento(AgregarMedicamento agregarMedicamento, EliminarMedicamento eliminarMedicamento, ComprarMedicamento comprarMedicamento, MedicamentoDisponible medicamentoDisponible) {
        this.agregarMedicamento = agregarMedicamento;
        this.eliminarMedicamento = eliminarMedicamento;
        this.comprarMedicamento = comprarMedicamento;
        this.medicamentoDisponible = medicamentoDisponible;
    }

    @PostMapping("/medicamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Medicamento agregar(@Valid @RequestBody MedicamentoDto medicamentoDto){
    return agregarMedicamento.ejecutar(medicamentoDto.getNombreMedicamento(), medicamentoDto.getCodigoMedicamento());
}

    @DeleteMapping("/medicamento/{codigoMedicamento}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable String codigoMedicamento) {
        eliminarMedicamento.borrar(codigoMedicamento);
    }


    @GetMapping("/medicamento")
    @ResponseStatus(HttpStatus.OK)
    public List<Medicamento> traerListaMedicamentos(){
        return medicamentoDisponible.consultar();
    }


    @PostMapping("/comprarMedicamento/{codigoMedicamento}")
    @ResponseStatus(HttpStatus.OK)
    public Compra comprar(@Valid @RequestBody ComprarDto comprarDto){
        return comprarMedicamento.realizarCompra(comprarDto.getNumeroIdentidad(), comprarDto.getCodigoMedicamento(), comprarDto.getMedioPago(),
                                        comprarDto.getRecetaMedica(), comprarDto.getCantidad());
    }
}
