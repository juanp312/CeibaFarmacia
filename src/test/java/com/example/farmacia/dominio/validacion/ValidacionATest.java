package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.Compra;
import com.example.farmacia.dominio.CompraDataBuilder;
import com.example.farmacia.dominio.MedioPagoEnum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidacionATest {

    private Validacion validacion;

    @Before
    public void setUp() throws Exception {
        validacion = new ValidacionA();
    }

    @Test
    public void medioPagoNoPuedeSerTarjeta() {
        //Arrange
        Compra compra = CompraDataBuilder.unaCompra()
                .conMedioPago(MedioPagoEnum.TARJETA.getTipoPago())
                .build();

        //Act
        Boolean resultadoValidacion = validacion.validar(compra, 0);

        //Assert
        assertFalse(resultadoValidacion);
    }

    @Test
    public void cantidadCompraNoPuedeSerMayorATres() {
        //Arrange
        Compra compra = CompraDataBuilder.unaCompra()
                .conMedioPago(MedioPagoEnum.EFECTIVO.getTipoPago())
                .conCantidad(4)
                .build();

        //Act
        Boolean resultadoValidacion = validacion.validar(compra, 0);

        //Assert
        assertFalse(resultadoValidacion);
    }

    @Test
    public void cantidadCompraNoPuedeSerMayorUnidadesDisponibles() {
        //Arrange
        Compra compra = CompraDataBuilder.unaCompra()
                .conMedioPago(MedioPagoEnum.EFECTIVO.getTipoPago())
                .conCantidad(3)
                .build();

        //Act
        Boolean resultadoValidacion = validacion.validar(compra, 2);

        //Assert
        assertFalse(resultadoValidacion);
    }

    @Test
    public void validacionExitosa() {
        //Arrange
        Compra compra = CompraDataBuilder.unaCompra()
                .conMedioPago(MedioPagoEnum.EFECTIVO.getTipoPago())
                .conCantidad(3)
                .build();

        //Act
        Boolean resultadoValidacion = validacion.validar(compra, 4);

        //Assert
        assertTrue(resultadoValidacion);
    }
}