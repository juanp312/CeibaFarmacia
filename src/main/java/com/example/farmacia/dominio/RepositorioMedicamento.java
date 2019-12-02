package com.example.farmacia.dominio;


public interface RepositorioMedicamento {

    Medicamento crear(Medicamento medicamento);

    Integer  eliminar(Integer id);

    Integer actualizarDisponibilidadMedicamento(Integer unidadesHaActualizar, String codigoMedicamento);

}
