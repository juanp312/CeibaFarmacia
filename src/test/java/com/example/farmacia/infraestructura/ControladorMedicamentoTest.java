package com.example.farmacia.infraestructura;

import com.example.farmacia.aplicacion.AgregarMedicamento;
import com.example.farmacia.aplicacion.ComprarMedicamento;
import com.example.farmacia.aplicacion.EliminarMedicamento;
import com.example.farmacia.aplicacion.MedicamentoDisponible;
import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.MedicamentoDataBuilder;
import com.example.farmacia.dominio.excepcion.RegistroNoEncontradoException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;


import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControladorMedicamentoTest {

    private MockMvc mockMvc;
    private ControladorMedicamento controladorMedicamento;

    @Mock
    private AgregarMedicamento agregarMedicamentoMock;

    @Mock
    private ComprarMedicamento comprarMedicamentoMock;

    @Mock
    private EliminarMedicamento eliminarMedicamentoMock;

    @Mock
    private MedicamentoDisponible medicamentoDisponibleMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controladorMedicamento = new ControladorMedicamento(agregarMedicamentoMock,eliminarMedicamentoMock,
                                comprarMedicamentoMock,medicamentoDisponibleMock);
        mockMvc = MockMvcBuilders.standaloneSetup(controladorMedicamento).build();
    }

    @Test
    public void agregarMedicamentoTest() throws Exception {
        //Arrange
        Medicamento medicamento = MedicamentoDataBuilder.crearMedicamentoNombreValido();
        String jsonBody = crearMedicamentoDtoRequestConNombreValido();
        when(agregarMedicamentoMock.ejecutar(anyString(),anyString())).thenReturn(medicamento);

        //Act Assert
        mockMvc.perform(post("/medicamento")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombreMedicamento", is(medicamento.getNombreMedicamento())))
                .andExpect(jsonPath("$.codigoMedicamento", is(medicamento.getCodigoMedicamento())));

        verify(agregarMedicamentoMock, times(1)).ejecutar(anyString(), anyString());

    }

    //todo crear comtrolador adviser en la capa de infraestructura
    @Test(expected = NestedServletException.class)
    public void agregarMedicamentoInvalidoTest() throws  Exception{
        //Arrange
        Medicamento medicamento = MedicamentoDataBuilder.crearMedicamentoNombreInvalido();
        String jsonBody = crearMedicamentoDtoRequestConNombreInvalido();
        when(agregarMedicamentoMock.ejecutar(anyString(), anyString())).thenThrow(new RegistroNoEncontradoException());

        //Act Assert
        mockMvc.perform(post("/medicamento")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());

        verify(agregarMedicamentoMock, times(1)).ejecutar(anyString(), anyString());
    }


    private String crearMedicamentoDtoRequestConNombreValido() {
        return "   { \"nombreMedicamento\": \"anombre_ejemplo\",\n" +
                "    \"codigoMedicamento\": \"codigo_ejemplo\"\n" +
                "}";
    }


    private String crearMedicamentoDtoRequestConNombreInvalido() {
        return "   { \"nombreMedicamento\": \"nombre_ejemplo\",\n" +
                "    \"codigoMedicamento\": \"codigo_ejemplo\"\n" +
                "}";
    }



}