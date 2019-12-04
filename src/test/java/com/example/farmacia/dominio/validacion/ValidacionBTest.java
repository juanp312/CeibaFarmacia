package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.entidades.Compra;
import com.example.farmacia.dominio.CompraDataBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidacionBTest {

    private  Validacion validacion;


    @Before
    public void setUp() throws Exception {
        validacion = new ValidacionB();
    }

    @Test
    public void recetaMedicaNoPuedeSerFalse() {

        //Arrange
        Compra compra = CompraDataBuilder.unaCompra()
                        .conRecetaMedica(false).build();

        //Act
        Boolean resultadoValidacion = validacion.validar(compra, 0);

        // Assert
        assertFalse(resultadoValidacion);
    }

    @Test
    public void medioPagoNoPuedeSerEfectivo(){

        //Arrange
        Compra compra = CompraDataBuilder.unaCompra()
                .conRecetaMedica(true)
                .conMedioPago(MedioPagoEnum.EFECTIVO.getTipoPago())
                .build();
        //Act
        Boolean resultadoValidacion = validacion.validar(compra, 0);

        //Assert
        assertFalse(resultadoValidacion);
    }

    @Test
    public void noPuedeSerMenorDeEdad(){

        //Arrange
        Compra compra = CompraDataBuilder.unaCompra()
                        .conRecetaMedica(true)
                        .conMedioPago(MedioPagoEnum.TARJETA.getTipoPago())
                        .conEdad(15)
                        .build();
        //Act
        Boolean resultadoValidacion = validacion.validar(compra, 0);

        //Assert
        assertFalse(resultadoValidacion);
    }


    @Test
    public void cantidadCompraNoPuedeSerMayorUnidadesDisponibles(){
        //Arrange
        Compra compra = CompraDataBuilder.unaCompra()
                .conRecetaMedica(true)
                .conMedioPago(MedioPagoEnum.TARJETA.getTipoPago())
                .conEdad(20)
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
                .conRecetaMedica(true)
                .conMedioPago(MedioPagoEnum.TARJETA.getTipoPago())
                .conEdad(20)
                .conCantidad(3)
                .build();

        //Act
        Boolean resultadoValidacion = validacion.validar(compra, 4);

        //Assert
        assertTrue(resultadoValidacion);
    }
}