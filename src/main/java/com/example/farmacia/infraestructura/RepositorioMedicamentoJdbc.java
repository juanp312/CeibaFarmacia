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


    //todo
    @Override
    public List<Medicamento> retornar() {
        return jdbcTemplate.query("select id from medicamento",
                new BeanPropertyRowMapper<Medicamento>(Medicamento.class));
    }

    @Override
    public String eliminar(String codigoMedicamento) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Integer registro = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("delete from medicamento where id = ?");
            ps.setString(1, codigoMedicamento);
            return ps;
        }, keyHolder);
        if (registro > 0) {
            return codigoMedicamento;
        } else {
            throw new RegistroInvalidoException();
        }
    }

    @Override
    public Medicamento crear(Medicamento medicamento) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        Integer registrosInsertados = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("insert into medicamento (NOMBRE, CODIGO)"
                            + "values(?, ?)");
            ps.setString(1, medicamento.getNombreMedicamento());
            ps.setString(2, medicamento.getCodigoMedicamento());
            return ps;
        }, keyHolder);

        if (registrosInsertados > 0) {
            return medicamento;
        } else {
            throw new RegistroInvalidoException();
        }
    }

    @Override
    public Medicamento retornarPorId(String codigoMedicamento) {
        return jdbcTemplate.queryForObject("select * from medicamento where id = ?",
                new Object[]{codigoMedicamento},
                new BeanPropertyRowMapper<Medicamento>(Medicamento.class));
    }



    @Override
    public Integer actualizarDisponibilidadMedicamento(Integer unidadesHaActualizar, String codigoMedicamento) {
        return jdbcTemplate.update("UPDATE MEDICAMENTO SET DISPONIBILIDAD = FALSE WHERE DISPONIBILIDAD = TRUE  AND CODIGO = ? AND ROWNUM <= ?",
                codigoMedicamento,
                unidadesHaActualizar);
    }
}


