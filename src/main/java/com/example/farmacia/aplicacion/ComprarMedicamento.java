package com.example.farmacia.aplicacion;


import com.example.farmacia.aplicacion.fabrica.FabricaCompra;
import com.example.farmacia.dominio.entidades.Compra;
import com.example.farmacia.dominio.servicios.ServicioCompra;
import org.springframework.stereotype.Component;

@Component
public class ComprarMedicamento {

    private final ServicioCompra servicioMedicamento;
    private final FabricaCompra fabricaCompra;

    public ComprarMedicamento(ServicioCompra servicioMedicamento, FabricaCompra fabricaCompra) {
        this.servicioMedicamento = servicioMedicamento;
        this.fabricaCompra = fabricaCompra;
    }

    public Compra realizarCompra(Long numeroIdentidad, Integer edad, String codigoMedicamento, String medioPago, Boolean recetaMedica,
                                 Integer cantidad){
        Compra compra = fabricaCompra.comprar(numeroIdentidad, edad, codigoMedicamento, medioPago, recetaMedica, cantidad);
        return  servicioMedicamento.comprarMedicamento(compra);
    }
}
