package com.example.farmacia.dominio;

import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import com.example.farmacia.dominio.excepcion.RegistroNoEncontradoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ServicioMedicamentoTest {

    private ServicioMedicamento servicioMedicamento;
    MockMvc mockMvc;

    @Mock
    private RepositorioMedicamento repositorioMedicamentoMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servicioMedicamento = new ServicioMedicamento(repositorioMedicamentoMock);
        mockMvc = MockMvcBuilders.standaloneSetup(servicioMedicamento).build();
    }

    @Test
    public void adicionarMedicamentoConATest() {

        //Arrange
        Medicamento medicamento = MedicamentoDataBuilder.crearMedicamentoNombreValidoConA();
        when(repositorioMedicamentoMock.crear(any(Medicamento.class))).thenReturn(medicamento);

        //Act
        Medicamento medicamentoGuardado = servicioMedicamento.adicionarMedicamento(medicamento);

        // Assert
        verify(repositorioMedicamentoMock, times(1)).crear(any(Medicamento.class));
        Assert.assertEquals(medicamentoGuardado, medicamento);
    }

    @Test
    public void adicionarMedicamentoConBTest() {

        //Arrange
        Medicamento medicamento = MedicamentoDataBuilder.crearMedicamentoNombreValidoConB();
        when(repositorioMedicamentoMock.crear(any(Medicamento.class))).thenReturn(medicamento);

        //Act
        Medicamento medicamentoGuardado = servicioMedicamento.adicionarMedicamento(medicamento);

        // Assert
        verify(repositorioMedicamentoMock, times(1)).crear(any(Medicamento.class));
        Assert.assertEquals(medicamentoGuardado, medicamento);
    }

    @Test(expected = RegistroInvalidoException.class)
    public void adicionarMedicamentoInvalidoTest() throws  Exception {
        //Arrange
        Medicamento medicamento = MedicamentoDataBuilder.crearMedicamentoNombreInvalido();

        //Act
        Medicamento medocamentoNoGuardado = servicioMedicamento.adicionarMedicamento(medicamento);

        //Assert
        verify(repositorioMedicamentoMock, times(0)).crear(any(Medicamento.class));

    }

    @Test
    public void eliminarMedicamentoTest() throws  Exception {
        //Arrange
        Integer id = 123;
        when(repositorioMedicamentoMock.eliminar(anyInt())).thenReturn(1);

        //Act
        servicioMedicamento.eliminarMedicamento(1);

        //Assert
        verify(repositorioMedicamentoMock, times(1)).eliminar(anyInt());

    }

    @Test(expected = RegistroNoEncontradoException.class)
    public void registroNoSePudoEliminarTest() throws  Exception {
        //Arrange
        Integer id = 123;
        when(repositorioMedicamentoMock.eliminar(anyInt())).thenThrow(new EmptyResultDataAccessException(1));

        //Act
        servicioMedicamento.eliminarMedicamento(1);

    }

}