package com.example.farmacia.dominio;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioMedicamento {
    List<Medicamento> retornarMedicamentos();

    void eliminarMedicamento(String id);

}
