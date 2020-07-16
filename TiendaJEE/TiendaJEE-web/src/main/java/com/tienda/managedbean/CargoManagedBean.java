/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.managedbean;

import com.entidades.session.CargoFacadeLocal;
import com.tienda.entidades.Cargo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author WENDY
 */
@Named(value = "cargoManagedBean")
@ViewScoped
public class CargoManagedBean implements Serializable, ManagedBeanInterface<Cargo>{
//PASO 1
    @EJB
    private CargoFacadeLocal cargoFacadeLocal;
    
    
    //Constructor
    public CargoManagedBean() {
    }
    
    //variable de tipo listaCargos
    private List<Cargo> listaCargos;
    
    
    //OBJETO DE TIPO CARGO    
    private Cargo cargo;
    
    
    //PASO 2
    @PostConstruct
    public void init (){
      listaCargos = cargoFacadeLocal.findAll();
    }

    @Override
    public void nuevo() {
        
        cargo=new Cargo();//se crea un nuevo objeto de cargo
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void grabar() {
        
        try{
            if(cargo.getCodigo()==null){
                cargoFacadeLocal.create(cargo);
            }else{
                cargoFacadeLocal.edit(cargo);
            }
            cargo=null;
            listaCargos=cargoFacadeLocal.findAll();
            
            mostrarMensajeTry("SE REGISTRO EXITOSAMENTE", FacesMessage.SEVERITY_INFO);
            
        }catch (Exception ex) {
            mostrarMensajeTry("OCURRIÓ UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionar(Cargo c) {
        cargo=c;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Cargo c) {
    try{
        //7 Elimino el empleado 
        cargoFacadeLocal.remove(c);
        //listo los empleados
        listaCargos=cargoFacadeLocal.findAll();
        mostrarMensajeTry("CARGO ELIMINADO", FacesMessage.SEVERITY_INFO);
    }catch(Exception e){
        mostrarMensajeTry("HA OCURRIDO UN ERROR", FacesMessage.SEVERITY_ERROR);
        
    }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelar() {
       cargo=null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    
}
