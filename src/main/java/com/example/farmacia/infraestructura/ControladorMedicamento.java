package com.example.farmacia.infraestructura;

import com.example.farmacia.aplicacion.AgregarMedicamento;
import com.example.farmacia.aplicacion.EliminarMedicamento;
import com.example.farmacia.dominio.Medicamento;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorMedicamento {

    private final AgregarMedicamento agregarMedicamento;
    private final EliminarMedicamento eliminarMedicamento;

    public ControladorMedicamento(AgregarMedicamento agregarMedicamento, EliminarMedicamento eliminarMedicamento) {
        this.agregarMedicamento = agregarMedicamento;
        this.eliminarMedicamento = eliminarMedicamento;
    }

    @PostMapping("/medicamento")
    public Medicamento agregar(String nombre, String codigoMedicamento){
    return agregarMedicamento.ejecutar(nombre, codigoMedicamento);
}

    @DeleteMapping("/medicamento/{nombre}/{codigoMedicamento}")
    public void eliminar(String codigoMedicamento){
        eliminarMedicamento.borrar(codigoMedicamento);
    }
}
