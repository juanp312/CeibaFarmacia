package com.example.farmacia.infraestructura;

import com.example.farmacia.dominio.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio extends JpaRepository <Medicamento, String> {
}
