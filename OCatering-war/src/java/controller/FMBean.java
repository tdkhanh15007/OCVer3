/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import MyEntity.FoodMatPK;

/**
 *
 * @author K
 */
public class FMBean {
    int foodID,matID;
    FoodMatPK fmEntity;
    double quantity;

    public FMBean() {
    }

    public FMBean(FoodMatPK fmEntity, double quantity) {
        this.fmEntity = fmEntity;
        this.quantity = quantity;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getMatID() {
        return matID;
    }

    public void setMatID(int matID) {
        this.matID = matID;
    }

    public FoodMatPK getFmEntity() {
        return fmEntity;
    }

    public void setFmEntity(FoodMatPK fmEntity) {
        this.fmEntity = fmEntity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
}
