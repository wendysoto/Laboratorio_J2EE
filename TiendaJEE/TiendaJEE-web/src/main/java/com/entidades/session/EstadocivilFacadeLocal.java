/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades.session;

import com.tienda.entidades.Estadocivil;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author WENDY
 */
@Local
public interface EstadocivilFacadeLocal {

    void create(Estadocivil estadocivil);

    void edit(Estadocivil estadocivil);

    void remove(Estadocivil estadocivil);

    Estadocivil find(Object id);

    List<Estadocivil> findAll();

    List<Estadocivil> findRange(int[] range);

    int count();
    
}
