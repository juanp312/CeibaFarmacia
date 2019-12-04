package com.example.farmacia.infraestructura;

import com.example.farmacia.dominio.entidades.Medicamento;
import com.example.farmacia.dominio.MedicamentoDataBuilder;
import com.example.farmacia.dominio.puertos.RepositorioMedicamento;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositorioMedicamentoJdbcTest {

    @Autowired
    RepositorioMedicamento repositorioMedicamento;

    @Test
    public void crear() {
        //Arrange
        Medicamento medicamento = MedicamentoDataBuilder.crearMedicamentoNombreValidoConA();

        //Act
        Medicamento medicamentoCreado = repositorioMedicamento.crear(medicamento);

        //Assert
        Assert.assertNotNull(medicamentoCreado);
    }

    @Test
    @Sql("/insercionMedicamento.sql")
    public void eliminar() {
        //Arrange
        // se envio por el archivo sql
        //Act
        Integer medicamentoEliminado = repositorioMedicamento.eliminar(40002);

        //Assert
        Assert.assertTrue(medicamentoEliminado > 0);
    }

    @Test
    @Sql("/medicamentosDisponibles.sql")
    public void actualizarDisponibilidadMedicamento() {
        //Arrange
        //se envio por el archivo sql
        //Act
        Integer medicamentoHaActualizar = repositorioMedicamento.actualizarDisponibilidadMedicamento(3, "123");

        //Assert
        Assert.assertTrue(medicamentoHaActualizar == 3);
    }
}