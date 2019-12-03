package com.example.farmacia.infraestructura;

import com.example.farmacia.aplicacion.ComprarMedicamento;
import com.example.farmacia.aplicacion.ComprasHechas;
import com.example.farmacia.dominio.Compra;
import com.example.farmacia.dominio.CompraDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControladorCompraTest {


    MockMvc mockMvc;
    ControladorCompra controladorCompra;

    @Mock
    ComprarMedicamento comprarMedicamentoMock;

    @Mock
    ComprasHechas comprasHechasMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controladorCompra = new ControladorCompra(comprarMedicamentoMock, comprasHechasMock);
        mockMvc = MockMvcBuilders.standaloneSetup(controladorCompra).build();
    }
    @Test
    public void comprar() throws Exception {

        //Arrange
        Compra compra = CompraDataBuilder.crearCompra();
        String jsonBody = crearCompraRequest();
        when(comprarMedicamentoMock.realizarCompra(anyLong(), anyInt(),anyString(),anyString(), anyBoolean(), anyInt())).thenReturn(compra);

        //Act Assert
        mockMvc.perform(post("/comprarMedicamento")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(comprarMedicamentoMock, times(1)).realizarCompra(anyLong(), anyInt(),anyString(),anyString(), anyBoolean(), anyInt());
    }

    private String crearCompraRequest() {
        return "   { \"codigoMedicamento\": \"nombre_ejemplo\",\n" +
                "    \"numeroIdentidad\": 20,\n" +
                "    \"edad\":  30,\n" +
                "    \"medioPago\": \"pago_ejemplo\",\n" +
                "    \"recetaMedica\": true,\n" +
                "    \"cantidad\":  2\n" +
                "}";
    }
    }

  //  @Test
   // public void listaCompras() {
    //}
