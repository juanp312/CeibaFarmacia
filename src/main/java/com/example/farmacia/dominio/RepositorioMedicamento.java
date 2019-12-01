package com.example.farmacia.dominio;



import java.util.List;


public interface RepositorioMedicamento {

    Medicamento crear(Medicamento medicamento);

    List<Medicamento> retornar();

    String  eliminar(String codigoMedicamento);

    Medicamento retornarPorId(String codigoMedicamento);

    List<Medicamento> stockDisponible();
}
