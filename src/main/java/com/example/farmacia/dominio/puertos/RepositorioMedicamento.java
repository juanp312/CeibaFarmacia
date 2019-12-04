package com.example.farmacia.dominio.puertos;


import com.example.farmacia.dominio.entidades.Medicamento;

public interface RepositorioMedicamento {

    Medicamento crear(Medicamento medicamento);

    Integer  eliminar(Integer id);

    Integer actualizarDisponibilidadMedicamento(Integer unidadesHaActualizar, String codigoMedicamento);

}
