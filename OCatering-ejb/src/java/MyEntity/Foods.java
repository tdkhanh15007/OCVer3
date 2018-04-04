/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyEntity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Khanh
 */
@Entity
@Table(name = "Foods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foods.findAll", query = "SELECT f FROM Foods f"),
    @NamedQuery(name = "Foods.findByFoodId", query = "SELECT f FROM Foods f WHERE f.foodId = :foodId"),
    @NamedQuery(name = "Foods.findByName", query = "SELECT f FROM Foods f WHERE f.name = :name"),
    @NamedQuery(name = "Foods.findByDescription", query = "SELECT f FROM Foods f WHERE f.description = :description")})
public class Foods implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Integer foodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 300)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "img")
    private String img;
    @ManyToMany(mappedBy = "foodsCollection")
    private Collection<Caterer> catererCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foods")
    private Collection<CusOrderDetails> cusOrderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foods")
    private Collection<FoodMat> foodMatCollection;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private Category catId;

    public Foods() {
    }

    public Foods(Integer foodId) {
        this.foodId = foodId;
    }

    public Foods(Integer foodId, String name) {
        this.foodId = foodId;
        this.name = name;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @XmlTransient
    public Collection<Caterer> getCatererCollection() {
        return catererCollection;
    }

    public void setCatererCollection(Collection<Caterer> catererCollection) {
        this.catererCollection = catererCollection;
    }

    @XmlTransient
    public Collection<CusOrderDetails> getCusOrderDetailsCollection() {
        return cusOrderDetailsCollection;
    }

    public void setCusOrderDetailsCollection(Collection<CusOrderDetails> cusOrderDetailsCollection) {
        this.cusOrderDetailsCollection = cusOrderDetailsCollection;
    }

    @XmlTransient
    public Collection<FoodMat> getFoodMatCollection() {
        return foodMatCollection;
    }

    public void setFoodMatCollection(Collection<FoodMat> foodMatCollection) {
        this.foodMatCollection = foodMatCollection;
    }

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodId != null ? foodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foods)) {
            return false;
        }
        Foods other = (Foods) object;
        if ((this.foodId == null && other.foodId != null) || (this.foodId != null && !this.foodId.equals(other.foodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.Foods[ foodId=" + foodId + " ]";
    }

    public Foods(String name, String description, String img, Category catId) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.catId = catId;
    }
    
}
