package com.example.farmacia.infraestructura.controlador;

import com.example.farmacia.aplicacion.AgregarMedicamento;
import com.example.farmacia.aplicacion.EliminarMedicamento;
import com.example.farmacia.dominio.entidades.Medicamento;
import com.example.farmacia.infraestructura.dto.MedicamentoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ControladorMedicamento {

    private final AgregarMedicamento agregarMedicamento;
    private final EliminarMedicamento eliminarMedicamento;

    public ControladorMedicamento(AgregarMedicamento agregarMedicamento, EliminarMedicamento eliminarMedicamento) {
        this.agregarMedicamento = agregarMedicamento;
        this.eliminarMedicamento = eliminarMedicamento;
    }

    @CrossOrigin
    @PostMapping("/medicamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Medicamento agregar(@Valid @RequestBody MedicamentoDto medicamentoDto){
    return agregarMedicamento.ejecutar(medicamentoDto.getNombreMedicamento(), medicamentoDto.getCodigoMedicamento()
    );
}

    @CrossOrigin
    @DeleteMapping("/medicamento/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable Integer id) {
        eliminarMedicamento.borrar(id);
    }



}
