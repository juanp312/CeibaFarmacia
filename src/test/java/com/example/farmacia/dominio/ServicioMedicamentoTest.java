package com.example.farmacia.dominio;

import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ServicioMedicamentoTest {

    private ServicioMedicamento servicioMedicamento;
    MockMvc mockMvc;

    @Mock
    private RepositorioMedicamento repositorioMedicamentoMock;

    @Mock
    private RepositorioComprar repositorioComprarMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servicioMedicamento = new ServicioMedicamento(repositorioMedicamentoMock, repositorioComprarMock);
        mockMvc = MockMvcBuilders.standaloneSetup(servicioMedicamento).build();
    }

    @Test
    public void adicionarMedicamentoTest() {

        //Arrange
        Medicamento medicamento = MedicamentoDataBuilder.crearMedicamentoNombreValido();
        when(repositorioMedicamentoMock.crearMedicamento(any(Medicamento.class))).thenReturn(medicamento);

        //Act
        Medicamento medicamentoGuardado = servicioMedicamento.adicionarMedicamento(medicamento);

        // Assert
        verify(repositorioMedicamentoMock, times(1)).crearMedicamento(any(Medicamento.class));
        Assert.assertEquals(medicamentoGuardado, medicamento);
    }

    @Test(expected = RegistroInvalidoException.class)
    public void adicionarMedicamentoInvalidoTest() throws  Exception {
        //Arrange
        Medicamento medicamento = MedicamentoDataBuilder.crearMedicamentoNombreInvalido();

        //Act
        Medicamento medocamentoNoGuardado = servicioMedicamento.adicionarMedicamento(medicamento);

        //Assert
        verify(repositorioMedicamentoMock, times(0)).crearMedicamento(any(Medicamento.class));

    }

}