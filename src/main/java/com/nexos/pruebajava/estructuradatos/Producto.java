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
public class Producto {   
    
    private String nombreProducto;
    private String tipoProducto;

    public Producto() {
    }
    
    public Producto(String nombreProducto, String tipoProducto){
        this.nombreProducto=nombreProducto;
        this.tipoProducto=tipoProducto;
    }
    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the tipoProducto
     */
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
}
