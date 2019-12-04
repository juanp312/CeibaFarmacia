package com.example.farmacia.infraestructura;

import com.example.farmacia.dominio.entidades.Compra;
import com.example.farmacia.dominio.CompraDataBuilder;
import com.example.farmacia.dominio.puertos.RepositorioCompra;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositorioCompraJdbcTest {

    @Autowired
    RepositorioCompra repositorioCompra;

    @Test
    public void crearCompraTest() {
        //Arrange
        Compra compra = CompraDataBuilder.crearCompra();

        //Act
        Compra compraCreada = repositorioCompra.crear(compra);

        //Assert
        Assert.assertNotNull(compraCreada);
    }


    @Test
    public void retornarListasCompra() {
        //Arrange
        insertarTresRegistrosDeCompra();

        //Act
        List<Compra> compras = repositorioCompra.retornar();

        //Assert
        Assert.assertTrue(compras.size() > 0);
        compras.stream().forEach(c -> Assert.assertNotNull(c));
    }

    @Test
    @Sql("/stock.sql")
    public void stockDisponibleTest() {
        //Arrange
        // La informacion de stock fue ingresada con la anotacion @Sql

        //Act
        Integer stockDisponible = repositorioCompra.stockDisponible("123");

        //Assert
        Assert.assertTrue(stockDisponible > 0);
        Assert.assertTrue(stockDisponible == 3);

    }

    private void insertarTresRegistrosDeCompra() {
        Compra compra = CompraDataBuilder.crearCompra();
        Stream.of(compra, compra, compra).forEach((c) -> repositorioCompra.crear(c) );
    }
}