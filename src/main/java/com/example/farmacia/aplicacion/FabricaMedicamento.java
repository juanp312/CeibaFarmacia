package com.example.farmacia.aplicacion;


import com.example.farmacia.dominio.Medicamento;


    public class FabricaMedicamento {
        public Medicamento crear(String nombre, String codigoMedicamento){
        return new Medicamento(nombre,codigoMedicamento);
    }

    public void suprimir(String nombre, String codigoMedicamento){

    }
}
