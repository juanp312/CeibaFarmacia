package com.example.farmacia.infraestructura.controlador;


import com.example.farmacia.aplicacion.ComprarMedicamento;
import com.example.farmacia.aplicacion.ComprasHechas;
import com.example.farmacia.dominio.entidades.Compra;
import com.example.farmacia.infraestructura.dto.ComprarDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControladorCompra {

    private final ComprarMedicamento comprarMedicamento;
    private final ComprasHechas comprasHechas;

    public ControladorCompra(ComprarMedicamento comprarMedicamento, ComprasHechas comprasHechas) {
        this.comprarMedicamento = comprarMedicamento;
        this.comprasHechas = comprasHechas;
    }

    @CrossOrigin
    @PostMapping("/comprarMedicamento")
    @ResponseStatus(HttpStatus.OK)
    public Compra comprar(@Valid @RequestBody ComprarDto comprarDto){
        return comprarMedicamento.realizarCompra(comprarDto.getNumeroIdentidad(), comprarDto.getEdad(), comprarDto.getCodigoMedicamento(), comprarDto.getMedioPago(),
                comprarDto.getRecetaMedica(), comprarDto.getCantidad());
    }

    @CrossOrigin
    @GetMapping("/compras")
    @ResponseStatus(HttpStatus.OK)
    public List<Compra> listaCompras(){
        return comprasHechas.consultar();
    }
}
