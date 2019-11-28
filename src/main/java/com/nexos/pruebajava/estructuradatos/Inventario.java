/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexos.pruebajava.estructuradatos;

/**
 *
 * @author Juan Aguilar
 */
public class Inventario {

    private Producto producto;  
    private double valorUnitario;
    private int cantidadVendida;
    private int cantidadComprada;
    private int cantidadDisponible;
    private double valorTotalComprado;
    private double valorTotalVendido;
    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the cantidadVendida
     */
    public int getCantidadVendida() {
        return cantidadVendida;
    }

    /**
     * @param cantidadVendida the cantidadVendida to set
     */
    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    /**
     * @return the cantidadComprada
     */
    public int getCantidadComprada() {
        return cantidadComprada;
    }

    /**
     * @param cantidadComprada the cantidadComprada to set
     */
    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    /**
     * @return the cantidadDisponible
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * @param cantidadDisponible the cantidadDisponible to set
     */
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * @return the valorTotalComprado
     */
    public double getValorTotalComprado() {
        return valorTotalComprado;
    }

    /**
     * @param valorTotalComprado the valorTotalComprado to set
     */
    public void setValorTotalComprado(double valorTotalComprado) {
        this.valorTotalComprado = valorTotalComprado;
    }

    /**
     * @return the valorTotalVendido
     */
    public double getValorTotalVendido() {
        return valorTotalVendido;
    }

    /**
     * @param valorTotalVendido the valorTotalVendido to set
     */
    public void setValorTotalVendido(double valorTotalVendido) {
        this.valorTotalVendido = valorTotalVendido;
    }
    
}
