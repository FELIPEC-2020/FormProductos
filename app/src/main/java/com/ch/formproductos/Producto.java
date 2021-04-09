package com.ch.formproductos;

public class Producto {
    String pNombre;
    String pCodigo;
    double pValor;
    String pExento;
    String pCategoria;

    public Producto(String pNombre, String pCodigo, double pValor, String pExento, String pCategoria) {
        this.pNombre = pNombre;
        this.pCodigo = pCodigo;
        this.pValor = pValor;
        this.pExento = pExento;
        this.pCategoria = pCategoria;
    }

    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getpCodigo() {
        return pCodigo;
    }

    public void setpCodigo(String pCodigo) {
        this.pCodigo = pCodigo;
    }

    public double getpValor() {
        return pValor;
    }

    public void setpValor(double pValor) {
        this.pValor = pValor;
    }

    public String getpExento() {
        return pExento;
    }

    public void setpExento(String pExento) {
        this.pExento = pExento;
    }

    public String getpDescripcion() {
        return pCategoria;
    }

    public void setpDescripcion(String pDescripcion) {
        this.pCategoria = pDescripcion;
    }

    @Override
    public String toString() {
        return "Nombre: " + pNombre + "\n" +
                "Codigo:'" + pCodigo + " - $" +
                "Valor: " + pValor + "\n" +
                "Exento: " + pExento + "\n" +
                "Descripcion='" + pCategoria;
    }
}
