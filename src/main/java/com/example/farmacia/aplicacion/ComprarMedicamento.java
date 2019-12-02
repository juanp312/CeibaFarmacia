package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComprarMedicamento {

    private final ServicioCompra servicioMedicamento;
    private final FabricaCompra fabricaCompra;

    public ComprarMedicamento(ServicioCompra servicioMedicamento, FabricaCompra fabricaCompra) {
        this.servicioMedicamento = servicioMedicamento;
        this.fabricaCompra = fabricaCompra;
    }

    public Compra realizarCompra(Long numeroIdentidad, String codigoMedicamento, String medioPago, Boolean recetaMedica,
                                 Integer cantidad){
        Compra compra = fabricaCompra.comprar(numeroIdentidad, codigoMedicamento, medioPago, recetaMedica, cantidad);
        return  servicioMedicamento.comprarMedicamento(compra);
    }
}
