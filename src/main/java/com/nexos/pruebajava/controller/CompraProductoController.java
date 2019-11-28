/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexos.pruebajava.controller;

import com.nexos.pruebajava.estructuradatos.TipoProductoEnum;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juan Aguilar
 */
@ManagedBean
@ViewScoped
public class CompraProductoController {
    private String nombreProducto;
    private TipoProductoEnum tipoProducto;
    private double valorUnitario;
    private int cantidadComprada;
    private int cantidadDisponible;
    private double valorTotalComprado;

    
    
    public void addMessage(String mensaje){
        FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO,mensaje,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
    public TipoProductoEnum getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public void setTipoProducto(TipoProductoEnum tipoProducto) {
        this.tipoProducto = tipoProducto;
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
    
}
