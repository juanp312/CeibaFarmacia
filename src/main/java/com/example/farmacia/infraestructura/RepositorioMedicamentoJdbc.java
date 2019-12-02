package com.example.farmacia.infraestructura;

import com.example.farmacia.dominio.Medicamento;
import com.example.farmacia.dominio.RepositorioMedicamento;
import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
    public Integer eliminar(Integer id) {
        return jdbcTemplate.update("DELETE FROM MEDICAMENTO WHERE ID = ?",
                id);
    }

    @Override
    public Medicamento crear(Medicamento medicamento) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        Integer registrosInsertados = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO MEDICAMENTO (NOMBRE, CODIGO, DISPONIBILIDAD)"
                            + "VALUES (?, ?, ?)");
            ps.setString(1, medicamento.getNombreMedicamento());
            ps.setString(2, medicamento.getCodigoMedicamento());
            ps.setString(3, medicamento.getDisponibilidad().toString());
            return ps;
        }, keyHolder);

        if (registrosInsertados > 0) {
            return medicamento;
        } else {
            throw new RegistroInvalidoException();
        }
    }


    @Override
    public Integer actualizarDisponibilidadMedicamento(Integer unidadesHaActualizar, String codigoMedicamento) {
        return jdbcTemplate.update("UPDATE MEDICAMENTO SET DISPONIBILIDAD = FALSE WHERE DISPONIBILIDAD = TRUE  AND CODIGO = ? AND ROWNUM <= ?",
                codigoMedicamento,
                unidadesHaActualizar);
    }
}

