/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexos.pruebajava.controller;

import com.nexos.pruebajava.estructuradatos.Inventario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
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
public class VentaProductoController implements Serializable{
    
    private String nombreProducto;
    private String tipoProducto;
    private double valorUnitarioVenta;
    private int cantidadVendida;
    private int cantidadDisponible;
    private double valorTotalVendido;
    private List<String> productoNombres;
    private List<String> productoTipos;
    private boolean editable = true;
    private boolean renderTipo=false;
    private List<Inventario> inventarios;
    
    public VentaProductoController(){
        
    }
    
    @PostConstruct
    public void init(){
        productoNombres = new ArrayList<>();
        FacesContext context = FacesContext.getCurrentInstance();
        inventarios =
                (List<Inventario>) context.getExternalContext().getSessionMap().get("Inventarios")== null ? 
                new ArrayList<Inventario>():
                (List<Inventario>) context.getExternalContext().getSessionMap().get("Inventarios");
        if(inventarios.isEmpty())
        {
            addMessage("No ahi productos para vender");
        }else{
            editable=false;
            for(Inventario inv:inventarios)
            {
                productoNombres.add(inv.getProducto().getNombreProducto());
            }
            Set<String> hs = new HashSet<>();
            hs.addAll(productoNombres);
            productoNombres.clear();
            productoNombres.addAll(hs);
        }
    }
    
    public void cargarTipos(){
        productoTipos= new ArrayList<>();
        for (Inventario inv: inventarios)
        {
            if(inv.getProducto().getNombreProducto().equals(nombreProducto)){
                productoTipos.add(inv.getProducto().getTipoProducto());
            }
        }
    }
    
    public void registrarVentaProducto(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(nombreProducto == null){
            addMessage("Por favor seleccione un producto");
        } else if(tipoProducto == null){
            addMessage("Por favor seleccione un tipo de producto");
        }else
        {
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
                addMessage("No ahi productos para vender");
            }else{
                if(inventario.getCantidadDisponible()>=cantidadVendida)
                {
                    inventario.setCantidadVendida(inventario.getCantidadVendida()+cantidadVendida);
                    inventario.setValorUnitarioVenta(valorUnitarioVenta);
                    inventario.setCantidadDisponible(inventario.getCantidadDisponible()-cantidadVendida);
                    inventario.setValorTotalVendido(inventario.getValorTotalVendido()+(valorUnitarioVenta*cantidadVendida));
                    inventarios.set(index, inventario);
                    context.getExternalContext().getSessionMap().put("Inventarios", inventarios);
                    addMessage("Venta de producto registrada correctamente");
                }else{
                    addMessage("No ahi cantidad disponible para vender");
                }
            }
        }  
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
    public double getValorUnitarioVenta() {
        return valorUnitarioVenta;
    }

    /**
     * @param valorUnitarioVenta the valorUnitario to set
     */
    public void setValorUnitarioVenta(double valorUnitarioVenta) {
        this.valorUnitarioVenta = valorUnitarioVenta;
    }

    /**
     * @return the cantidadComprada
     */
    public int getCantidadVendida() {
        return cantidadVendida;
    }

    /**
     * @param cantidadVendida the cantidadComprada to set
     */
    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
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
    public double getValorTotalVendido() {
        return valorTotalVendido;
    }

    /**
     * @param valorTotalVendido the valorTotalComprado to set
     */
    public void setValorTotalVendido(double valorTotalVendido) {
        this.valorTotalVendido = valorTotalVendido;
    }

    /**
     * @return the productoNombres
     */
    public List<String> getProductoNombres() {
        return productoNombres;
    }

    /**
     * @param productoNombres the productoNombres to set
     */
    public void setProductoNombres(List<String> productoNombres) {
        this.productoNombres = productoNombres;
    }

    /**
     * @return the productoTipos
     */
    public List<String> getProductoTipos() {
        return productoTipos;
    }

    /**
     * @param productoTipos the productoTipos to set
     */
    public void setProductoTipos(List<String> productoTipos) {
        this.productoTipos = productoTipos;
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * @return the renderTipo
     */
    public boolean isRenderTipo() {
        return renderTipo;
    }

    /**
     * @param renderTipo the renderTipo to set
     */
    public void setRenderTipo(boolean renderTipo) {
        this.renderTipo = renderTipo;
    }
    
}
