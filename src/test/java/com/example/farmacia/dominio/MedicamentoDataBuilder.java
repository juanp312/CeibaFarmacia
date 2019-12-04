package com.example.farmacia.dominio;

import com.example.farmacia.dominio.entidades.Medicamento;

public class MedicamentoDataBuilder {

    private String nombreMedicamento;
    private String codigoMedicamento;
    private Boolean disponibilidad;


    private MedicamentoDataBuilder() {
    }

    public static MedicamentoDataBuilder unMedicamento() {
        return new MedicamentoDataBuilder();
    }

    public MedicamentoDataBuilder conNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
        return this;
    }


    public MedicamentoDataBuilder conCodigoMedicamento(String codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
        return this;
    }

    public MedicamentoDataBuilder conDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
        return this;
    }

    public Medicamento build() {
        return new Medicamento(this.nombreMedicamento, this.codigoMedicamento, this.disponibilidad);
    }

    public static Medicamento crearMedicamentoNombreValidoConA(){
        return MedicamentoDataBuilder.unMedicamento()
                .conNombreMedicamento("ANOMBRE_TEST")
                .conCodigoMedicamento("ACODIGO_TEST")
                .conDisponibilidad(Boolean.TRUE)
                .build();
    }


    public static Medicamento crearMedicamentoNombreValidoConB(){
        return MedicamentoDataBuilder.unMedicamento()
                .conNombreMedicamento("BNOMBRE_TEST")
                .conCodigoMedicamento("BCODIGO_TEST")
                .conDisponibilidad(Boolean.TRUE)
                .build();
    }


    public static Medicamento crearMedicamentoNombreInvalido(){
        return MedicamentoDataBuilder.unMedicamento()
                .conNombreMedicamento("NOMBRE_TEST")
                .conCodigoMedicamento("CODIGO_TEST")
                .conDisponibilidad(Boolean.TRUE)
                .build();
    }

}