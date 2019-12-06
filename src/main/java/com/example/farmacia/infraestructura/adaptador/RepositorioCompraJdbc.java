package com.example.farmacia.infraestructura.adaptador;

import com.example.farmacia.dominio.entidades.Compra;
import com.example.farmacia.dominio.excepcion.RegistroInvalidoException;
import com.example.farmacia.dominio.puertos.RepositorioCompra;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
                    .prepareStatement("INSERT INTO COMPRA (CODIGO_MEDICAMENTO, NUMERO_IDENTIDAD, EDAD, MEDIO_PAGO, RECETA, CANTIDAD)\n" +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, compra.getCodigoMedicamento());
            ps.setString(2, compra.getNumeroIdentidad().toString());
            ps.setString(3, compra.getEdad().toString());
            ps.setString(4, compra.getMedioPago());
            ps.setString(5, compra.getRecetaMedica().toString());
            ps.setString(6, compra.getCantidad().toString());
            return ps;
        }, keyHolder);
        return  compra;
    }

    @Override
    public Integer stockDisponible(String codigoMedicamento) {
        return (Integer) jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEDICAMENTO WHERE DISPONIBILIDAD = true AND CODIGO = ?",
                new Object[]{codigoMedicamento},
                Integer.class);
    }

    @Override
    public List<Compra> retornar() {
        return jdbcTemplate.query("SELECT * FROM COMPRA ",
                this::mapRow);
    }

    public Compra mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Compra(
                resultSet.getString("CODIGO_MEDICAMENTO"),
                resultSet.getLong("NUMERO_IDENTIDAD"),
                resultSet.getInt("EDAD"),
                resultSet.getString("MEDIO_PAGO"),
                resultSet.getBoolean("RECETA"),
                resultSet.getInt("CANTIDAD")
                );
    }
}


