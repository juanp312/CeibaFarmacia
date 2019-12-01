package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.Compra;
import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.ServicioMedicamento;
import com.example.farmacia.dominio.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComprarMedicamento {

    private final ServicioMedicamento servicioMedicamento;
    private final FabricaCompra fabricaCompra;

    public ComprarMedicamento(ServicioMedicamento servicioMedicamento, FabricaCompra fabricaCompra) {
        this.servicioMedicamento = servicioMedicamento;
        this.fabricaCompra = fabricaCompra;
    }

    public Compra realizarCompra(Long numeroIdentidad, String codigoMedicamento, String medioPago, Boolean recetaMedica,
                                 Integer cantidad){
        Compra compra = fabricaCompra.comprar(numeroIdentidad, codigoMedicamento, medioPago, recetaMedica, cantidad);
        return  servicioMedicamento.comprarMedicamento(compra);
    }
}
