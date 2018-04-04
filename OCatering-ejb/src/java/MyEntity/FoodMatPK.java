/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyEntity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Khanh
 */
@Embeddable
public class FoodMatPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_id")
    private int matId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "food_id")
    private int foodId;

    public FoodMatPK() {
    }

    public FoodMatPK(int matId, int foodId) {
        this.matId = matId;
        this.foodId = foodId;
    }

    public int getMatId() {
        return matId;
    }

    public void setMatId(int matId) {
        this.matId = matId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) matId;
        hash += (int) foodId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodMatPK)) {
            return false;
        }
        FoodMatPK other = (FoodMatPK) object;
        if (this.matId != other.matId) {
            return false;
        }
        if (this.foodId != other.foodId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.FoodMatPK[ matId=" + matId + ", foodId=" + foodId + " ]";
    }
    
}
