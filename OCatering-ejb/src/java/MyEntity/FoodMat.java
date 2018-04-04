/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyEntity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Khanh
 */
@Entity
@Table(name = "FoodMat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodMat.findAll", query = "SELECT f FROM FoodMat f"),
    @NamedQuery(name = "FoodMat.findByMatId", query = "SELECT f FROM FoodMat f WHERE f.foodMatPK.matId = :matId"),
    @NamedQuery(name = "FoodMat.findByFoodId", query = "SELECT f FROM FoodMat f WHERE f.foodMatPK.foodId = :foodId"),
    @NamedQuery(name = "FoodMat.findByQuantity", query = "SELECT f FROM FoodMat f WHERE f.quantity = :quantity")})
public class FoodMat implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FoodMatPK foodMatPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private double quantity;
    @JoinColumn(name = "food_id", referencedColumnName = "food_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Foods foods;
    @JoinColumn(name = "mat_id", referencedColumnName = "mat_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Material material;

    public FoodMat() {
    }

    public FoodMat(FoodMatPK foodMatPK) {
        this.foodMatPK = foodMatPK;
    }

    public FoodMat(FoodMatPK foodMatPK, double quantity) {
        this.foodMatPK = foodMatPK;
        this.quantity = quantity;
    }

    public FoodMat(int matId, int foodId) {
        this.foodMatPK = new FoodMatPK(matId, foodId);
    }

    public FoodMatPK getFoodMatPK() {
        return foodMatPK;
    }

    public void setFoodMatPK(FoodMatPK foodMatPK) {
        this.foodMatPK = foodMatPK;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Foods getFoods() {
        return foods;
    }

    public void setFoods(Foods foods) {
        this.foods = foods;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodMatPK != null ? foodMatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodMat)) {
            return false;
        }
        FoodMat other = (FoodMat) object;
        if ((this.foodMatPK == null && other.foodMatPK != null) || (this.foodMatPK != null && !this.foodMatPK.equals(other.foodMatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.FoodMat[ foodMatPK=" + foodMatPK + " ]";
    }

    public FoodMat(double quantity, Foods foods, Material material) {
        this.quantity = quantity;
        this.foods = foods;
        this.material = material;
    }
    
    
}
