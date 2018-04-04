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

    List<Integer> list1;
    List<Material> list2;
    List<FoodMat> list3;
    String name;
    double quantity;
    int id1,id2;

    public List<FoodMat> getList3() {
        return list3;
    }

    public void setList3(List<FoodMat> list3) {
        this.list3 = list3;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public List<Material> getList2() {
        return list2;
    }

    public void setList2(List<Material> list2) {
        this.list2 = list2;
    }

    public List<Integer> getList1() {
        return list1;
    }

    public void setList1(List<Integer> list1) {
        this.list1 = list1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * Creates a new instance of TestMngBean
     */
    public TestMngBean() {
    }
    
//    public void action1(){
//
//        FoodMat fm = foodMatFacade.test1(19,2);
//        id1 = fm.getFoods().getFoodId();
//        id2 =fm.getMaterial().getMatId();
//        quantity = fm.getQuantity();
//        list3 = new ArrayList<FoodMat>();
//        for (int i = 1; i < 5; i++) {
//            FoodMat fm1 = foodMatFacade.test1(19,i);
//            list3.add(fm1);
//        }
        
//        list3.add(fm);
//        System.out.println(list3);
//    }
    
//    public String idtoName(int id){
//        return materialFacade.find(id).getName();
//    }
}
