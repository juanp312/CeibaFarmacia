package com.example.farmacia.infraestructura;


import com.example.farmacia.aplicacion.ComprarMedicamento;
import com.example.farmacia.dominio.Compra;
import com.example.farmacia.infraestructura.dto.ComprarDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ControladorCompra {

    private final ComprarMedicamento comprarMedicamento;

    public ControladorCompra(ComprarMedicamento comprarMedicamento) {
        this.comprarMedicamento = comprarMedicamento;
    }

    @PostMapping("/comprarMedicamento")
    @ResponseStatus(HttpStatus.OK)
    public Compra comprar(@Valid @RequestBody ComprarDto comprarDto){
        return comprarMedicamento.realizarCompra(comprarDto.getNumeroIdentidad(), comprarDto.getCodigoMedicamento(), comprarDto.getMedioPago(),
                comprarDto.getRecetaMedica(), comprarDto.getCantidad());
    }
}
