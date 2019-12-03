package com.example.farmacia.dominio;

public class CompraDataBuilder {

    private String codigoMedicamento;
    private Long numeroIdentidad;
    private Integer edad;
    private String medioPago;
    private Boolean recetaMedica;
    private Integer cantidad;


    private CompraDataBuilder() {
    }

    public static CompraDataBuilder unaCompra() { return new CompraDataBuilder(); }

    public CompraDataBuilder conCodigoMedicamento(String codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
        return this;
    }

    public CompraDataBuilder conNumeroIdentidad(Long numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
        return this;
    }

    public CompraDataBuilder conEdad(Integer edad) {
        this.edad = edad;
        return this;
    }

    public CompraDataBuilder conMedioPago(String medioPago) {
        this.medioPago = medioPago;
        return this;
    }

    public CompraDataBuilder conRecetaMedica(Boolean recetaMedica) {
        this.recetaMedica = recetaMedica;
        return this;
    }

    public CompraDataBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }


    public Compra build() {
        return new Compra(
                this.codigoMedicamento,
                this.numeroIdentidad,
                this.edad,
                this.medioPago,
                this.recetaMedica,
                this.cantidad);
    }

    public static Compra crearCompra(){
        return CompraDataBuilder.unaCompra()
                .conCodigoMedicamento("CODIGO_MEDICAMENTO_TEST")
                .conNumeroIdentidad(123l)
                .conEdad(19)
                .conMedioPago(MedioPagoEnum.EFECTIVO.getTipoPago())
                .conCantidad(2)
                .conRecetaMedica(Boolean.TRUE)
                .build();
    }

}