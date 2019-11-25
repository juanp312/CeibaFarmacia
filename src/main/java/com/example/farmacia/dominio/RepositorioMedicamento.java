package com.example.farmacia.dominio;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioMedicamento {

    Medicamento crearMedicamento(Medicamento medicamento);

    List<Medicamento> retornarMedicamentos();

    Integer eliminarMedicamento(String codigoMedicamento);

}
