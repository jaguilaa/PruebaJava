/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexos.pruebajava.controller;

import com.nexos.pruebajava.estructuradatos.Inventario;
import com.nexos.pruebajava.estructuradatos.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class CompraProductoController implements Serializable{
    
    private String nombreProducto;
    private String tipoProducto;
    private double valorUnitarioCompra;
    private int cantidadComprada;
    private int cantidadDisponible;
    private double valorTotalComprado;

    public CompraProductoController(){
        
    }
    
    public void registrarCompraProducto(){
        FacesContext context = FacesContext.getCurrentInstance();   
        List<Inventario> inventarios =
                (List<Inventario>) context.getExternalContext().getSessionMap().get("Inventarios")== null ? 
                new ArrayList<Inventario>():
                (List<Inventario>) context.getExternalContext().getSessionMap().get("Inventarios");
        
        Inventario inventario=null;
        int index=0;
        boolean encontroInventario=false;
        for (Inventario inv:inventarios)
        {
            if(inv.getProducto().getNombreProducto().equals(nombreProducto) && inv.getProducto().getTipoProducto().equals(tipoProducto)){
                inventario=inv;
                encontroInventario=true;
            }
            if(!encontroInventario)
                index++;
        }
        if(inventario==null)
        {
            Producto producto = new Producto(nombreProducto,tipoProducto);
            inventario=new Inventario(cantidadComprada, valorUnitarioCompra, cantidadDisponible, valorTotalComprado);
            inventario.setProducto(producto);
            inventario.setCantidadDisponible(cantidadComprada);
            inventario.setValorTotalComprado(valorUnitarioCompra*cantidadComprada);
            inventarios.add(inventario);
        }else{
            inventario.setCantidadComprada(inventario.getCantidadComprada()+cantidadComprada);
            inventario.setValorUnitarioCompra(valorUnitarioCompra);
            inventario.setCantidadDisponible(inventario.getCantidadDisponible()+cantidadComprada);
            inventario.setValorTotalComprado(inventario.getValorTotalComprado()+(valorUnitarioCompra*cantidadComprada));
            inventarios.set(index, inventario);
        }
        
        context.getExternalContext().getSessionMap().put("Inventarios", inventarios);
        addMessage("Compra de producto registrada correctamente");
    }
    
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
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitarioCompra() {
        return valorUnitarioCompra;
    }

    /**
     * @param valorUnitarioCompra the valorUnitario to set
     */
    public void setValorUnitarioCompra(double valorUnitarioCompra) {
        this.valorUnitarioCompra = valorUnitarioCompra;
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
