package com.example.farmacia.infraestructura;

import com.example.farmacia.aplicacion.AgregarMedicamento;
import com.example.farmacia.aplicacion.ComprarMedicamento;
import com.example.farmacia.aplicacion.EliminarMedicamento;
import com.example.farmacia.aplicacion.MedicamentoDisponible;
import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.infraestructura.dto.MedicamentoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin
    @PostMapping("/medicamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Medicamento agregar(@RequestBody MedicamentoDto medicamentoDto){
    return agregarMedicamento.ejecutar(medicamentoDto.getNombreMedicamento(), medicamentoDto.getCodigoMedicamento());
}
    @CrossOrigin
    @DeleteMapping("/medicamento/{nombre}/{codigoMedicamento}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(String codigoMedicamento){
        eliminarMedicamento.borrar(codigoMedicamento);
    }

    @CrossOrigin
    @GetMapping("/medicamentosDisponibles")
    @ResponseStatus(HttpStatus.OK)
    public List<Medicamento> traerListaMedicamentos(){
        return medicamentoDisponible.consultar();
    }

    @CrossOrigin
    @PostMapping("/comprarMedicamento/{codigoMedicamento}")
    @ResponseStatus(HttpStatus.OK)
    public Medicamento comprar(String nombre, String codigoMedicamento){
        return comprarMedicamento.realizarCompra(nombre, codigoMedicamento);
    }
}
