/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import MyEntity.FoodMat;
import MySsbean.MaterialFacadeLocal;
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
public class TestMngb {
    @EJB
    private MaterialFacadeLocal materialFacade;
    public List<FoodMat> listFM;
    String key1;

    public List<FoodMat> getListFM() {
        return listFM;
    }

    public void setListFM(List<FoodMat> listFM) {
        this.listFM = listFM;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }
    public void searchAction() {
        listFM = materialFacade.listMatbyName(key1, 79);        
    }
    
    
    /**
     * Creates a new instance of TestMngb
     */
    public TestMngb() {
    }
    
}
