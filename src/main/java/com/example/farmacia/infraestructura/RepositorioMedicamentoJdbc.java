package com.example.farmacia.infraestructura;

import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.RepositorioMedicamento;
import com.example.farmacia.dominio.excepcion.RegistroNoInsertadoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
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
    public Integer eliminarMedicamento(String codigoMedicamento) {
        return jdbcTemplate.update("delete from medicamento where id =?",
                            new Object[]{codigoMedicamento});
    }

    @Override
    public Medicamento crearMedicamento(Medicamento medicamento) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        Integer registrosInsertados = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("insert into medicamento (NOMBRE, CODIGO)"
                                    + "values(?, ?)");
            ps.setString(1, medicamento.getNombreMedicamento());
            ps.setString(2, medicamento.getCodigoMedicamento());
            return ps;
        }, keyHolder);

        if(registrosInsertados > 0) {
            return medicamento;
        } else {
            throw new RegistroNoInsertadoException();
        }
    }
}
