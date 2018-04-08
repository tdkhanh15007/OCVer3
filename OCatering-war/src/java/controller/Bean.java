/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MyEntity.FoodMat;
import MyEntity.Foods;
import MyEntity.Material;
import MySsbean.FoodMatFacadeLocal;
import MySsbean.FoodsFacadeLocal;
import MySsbean.MaterialFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class Bean implements Serializable {
    @EJB
    private FoodsFacadeLocal foodsFacade;
    @EJB
    private FoodMatFacadeLocal foodMatFacade;
    @EJB
    private MaterialFacadeLocal materialFacade;

    private List<FoodMat> foodmats;
    private FoodMat foodmat;

    public String submit(int fID,int mID,double a) {
        System.out.println(fID+" met:"+mID+" quan:"+a);
        Foods f1 = foodsFacade.find(fID);
        Material m1 = materialFacade.find(mID);
        FoodMat fm1 = foodMatFacade.returnFM(m1, f1);
        fm1.setQuantity(555);
        foodMatFacade.edit(fm1);
        getFoodmats();
        return "test2";
    }

    public List<FoodMat> getFoodmats() {
        return materialFacade.listMatbyName("h", 19);
    }

    public FoodMat getFoodmat() {
        return foodmat;
    }

    public void setFoodmat(FoodMat foodmat) {
        this.foodmat = foodmat;
    }

}
