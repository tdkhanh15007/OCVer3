/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import MyEntity.FoodMat;
import MyEntity.FoodMatPK;
import MyEntity.Material;
import MySsbean.FoodMatFacadeLocal;
import MySsbean.MaterialFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class TestMngBean {
    @EJB
    private FoodMatFacadeLocal foodMatFacade;
    @EJB
    private MaterialFacadeLocal materialFacade;

    public List<FoodMat> list3;
    String name;

    public void action1(){
        list3 = materialFacade.listMatbyName(name, 50);
    }
    public List<FoodMat> getList3() {
        return list3;
    }

    public void setList3(List<FoodMat> list3) {
        this.list3 = list3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
