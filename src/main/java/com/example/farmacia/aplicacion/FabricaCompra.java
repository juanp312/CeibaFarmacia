package com.example.farmacia.aplicacion;

import com.example.farmacia.dominio.Compra;
import org.springframework.stereotype.Component;

@Component
public class FabricaCompra {

    public Compra comprar(Long numeroIdentidad, String codigoMedicamento, String medioPago, Boolean recetaMedica,
                          Integer cantidad){
        return new Compra (codigoMedicamento, numeroIdentidad,  medioPago, recetaMedica, cantidad);
    }
}
