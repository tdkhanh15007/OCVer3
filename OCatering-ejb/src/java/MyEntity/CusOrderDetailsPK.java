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
public class CusOrderDetailsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cusorder_id")
    private int cusorderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "food_id")
    private int foodId;

    public CusOrderDetailsPK() {
    }

    public CusOrderDetailsPK(int cusorderId, int foodId) {
        this.cusorderId = cusorderId;
        this.foodId = foodId;
    }

    public int getCusorderId() {
        return cusorderId;
    }

    public void setCusorderId(int cusorderId) {
        this.cusorderId = cusorderId;
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
        hash += (int) cusorderId;
        hash += (int) foodId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CusOrderDetailsPK)) {
            return false;
        }
        CusOrderDetailsPK other = (CusOrderDetailsPK) object;
        if (this.cusorderId != other.cusorderId) {
            return false;
        }
        if (this.foodId != other.foodId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.CusOrderDetailsPK[ cusorderId=" + cusorderId + ", foodId=" + foodId + " ]";
    }
    
}
