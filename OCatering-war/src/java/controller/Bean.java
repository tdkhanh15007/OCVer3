/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MyEntity.FoodMat;
import MySsbean.FoodMatFacadeLocal;
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
    private FoodMatFacadeLocal foodMatFacade;
    @EJB
    private MaterialFacadeLocal materialFacade;

    private List<FoodMat> foodmats;
    private FoodMat foodmat;

    public void submit(int fID,int mID) {
        System.out.println(fID+"met"+mID);
//        System.out.println(foodmat);
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
