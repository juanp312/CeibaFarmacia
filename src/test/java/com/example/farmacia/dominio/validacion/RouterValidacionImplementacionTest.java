package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouterValidacionImplementacionTest {

    private RouterValidacion routerValidacion;

    @Before
    public void setUp() throws Exception {
        routerValidacion = new RouterValidacionImplementacion();
    }

    @Test
    public void direcionarCodigoConATest() {
        //Arrange
        String codigoEmpiezaConA = "aCodigo";

        //Act
        Validacion validacion = routerValidacion.direccionar(codigoEmpiezaConA);

        //Assert
        assertTrue(validacion instanceof ValidacionA);
    }

    @Test
    public void direccionarCodigoConBTest(){
        //Arrange
        String codigoEmpiezaConB = "bCodigo";

        //Act
        Validacion validacion = routerValidacion.direccionar(codigoEmpiezaConB);

        //Assert
        assertTrue(validacion instanceof ValidacionB);
    }

    @Test(expected = RegistroInvalidoException.class)
    public void direcionarCodigoDiferenteAoBTest() {
        //Arrange
        String codigoEmpiezaConA = "Codigo";

        //Act
        Validacion validacion = routerValidacion.direccionar(codigoEmpiezaConA);

    }
}