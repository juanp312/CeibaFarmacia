package com.example.farmacia.aplicacion;

import com.example.farmacia.dominio.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio extends JpaRepository <Medicamento, String> {
}
