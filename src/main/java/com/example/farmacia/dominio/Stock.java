package com.example.farmacia.dominio;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private Integer stockId;
    private Integer cantidadVendida;
    private Integer cantidadDisponible;
    private String codigoMedicamento;
    private List<Compra> compras = new ArrayList<>();

    public Stock(Integer stockId, Integer cantidadVendida, Integer cantidadDisponible, String codigoMedicamento, List<Compra> compras) {
        this.stockId = stockId;
        this.cantidadVendida = cantidadVendida;
        this.cantidadDisponible = cantidadDisponible;
        this.codigoMedicamento = codigoMedicamento;
        this.compras = compras;
    }

    public Integer getStockId() {
        return stockId;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public final void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public final void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}
