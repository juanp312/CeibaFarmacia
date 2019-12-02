package com.example.farmacia.infraestructura;

import com.example.farmacia.dominio.*;
import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class RepositorioCompraJdbc implements RepositorioCompra {

    private final JdbcTemplate jdbcTemplate;

    public RepositorioCompraJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Compra crear(Compra compra) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        Integer registrosInsertados = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO COMPRA (CODIGO_MEDICAMENTO, NUMERO_IDENTIDAD, MEDIO_PAGO, RECETA, CANTIDAD)\n" +
                            "VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, compra.getCodigoMedicamento());
            ps.setString(2, compra.getNumeroIdentidad().toString());
            ps.setString(3, compra.getMedioPago());
            ps.setString(4, compra.getRecetaMedica().toString());
            ps.setString(5, compra.getCantidad().toString());
            return ps;
        }, keyHolder);

        if (registrosInsertados > 0) {
            return compra;
        } else {
            throw new RegistroInvalidoException();
        }
    }

    @Override
    public Integer stockDisponible(String codigoMedicamento) {
        return (Integer) jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEDICAMENTO WHERE DISPONIBILIDAD = true AND CODIGO = ?",
                new Object[]{codigoMedicamento},
                Integer.class);
    }

}


