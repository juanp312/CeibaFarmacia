package com.example.farmacia.dominio;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioMedicamento {

    Medicamento crear(Medicamento medicamento);

    List<Medicamento> retornar();

    String  eliminar(String codigoMedicamento);

    Medicamento retornarPorId(String codigoMedicamento);

}
