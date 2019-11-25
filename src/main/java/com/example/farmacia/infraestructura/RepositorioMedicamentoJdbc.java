package com.example.farmacia.infraestructura;

import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.RepositorioMedicamento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioMedicamentoJdbc implements RepositorioMedicamento {

    private final JdbcTemplate jdbcTemplate;


    public RepositorioMedicamentoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Medicamento> retornarMedicamentos() {
        return null;
    }

    @Override
    public void eliminarMedicamento(String codigoMedicamento) {

    }
}
