package com.example.farmacia.dominio.validacion;

import com.example.farmacia.dominio.entidades.Compra;

public interface Validacion {

    Boolean validar(Compra compra, Integer unidadesDisponibles);




}
