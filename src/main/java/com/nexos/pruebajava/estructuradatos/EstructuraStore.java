/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexos.pruebajava.estructuradatos;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Juan Aguilar
 */
@Singleton
@Startup
public class EstructuraStore {
   

   @PostConstruct
   public void init() {
       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
       session.setAttribute("Inventarios", new ArrayList<Inventario>());
   }
   
   @PreDestroy
   public void destroy() {
      System.out.println("SingletonBean is going to be destroyed");
   }

}
