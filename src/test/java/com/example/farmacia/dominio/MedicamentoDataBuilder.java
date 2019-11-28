package com.example.farmacia.dominio;

public class MedicamentoDataBuilder {

    private String nombreMedicamento;
    private String codigoMedicamento;


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

    public Medicamento build() {
        return new Medicamento(this.nombreMedicamento, this.codigoMedicamento, null);
    }

    public static Medicamento crearMedicamentoNombreValido(){
        return MedicamentoDataBuilder.unMedicamento()
                .conNombreMedicamento("ANOMBRE_TEST")
                .conCodigoMedicamento("CODIGO_TEST")
                .build();
    }


    public static Medicamento crearMedicamentoNombreInvalido(){
        return MedicamentoDataBuilder.unMedicamento()
                .conNombreMedicamento("NOMBRE_TEST")
                .conCodigoMedicamento("CODIGO_TEST")
                .build();
    }

}