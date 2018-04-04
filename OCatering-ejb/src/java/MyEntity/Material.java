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
@Table(name = "Material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByMatId", query = "SELECT m FROM Material m WHERE m.matId = :matId"),
    @NamedQuery(name = "Material.findByName", query = "SELECT m FROM Material m WHERE m.name = :name"),
    @NamedQuery(name = "Material.findByCount", query = "SELECT m FROM Material m WHERE m.count = :count")})
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mat_id")
    private Integer matId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "count")
    private String count;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
    private Collection<SuppOrderDetails> suppOrderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
    private Collection<FoodMat> foodMatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
    private Collection<MatSup> matSupCollection;

    public Material() {
    }

    public Material(Integer matId) {
        this.matId = matId;
    }

    public Material(Integer matId, String name, String count) {
        this.matId = matId;
        this.name = name;
        this.count = count;
    }

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @XmlTransient
    public Collection<SuppOrderDetails> getSuppOrderDetailsCollection() {
        return suppOrderDetailsCollection;
    }

    public void setSuppOrderDetailsCollection(Collection<SuppOrderDetails> suppOrderDetailsCollection) {
        this.suppOrderDetailsCollection = suppOrderDetailsCollection;
    }

    @XmlTransient
    public Collection<FoodMat> getFoodMatCollection() {
        return foodMatCollection;
    }

    public void setFoodMatCollection(Collection<FoodMat> foodMatCollection) {
        this.foodMatCollection = foodMatCollection;
    }

    @XmlTransient
    public Collection<MatSup> getMatSupCollection() {
        return matSupCollection;
    }

    public void setMatSupCollection(Collection<MatSup> matSupCollection) {
        this.matSupCollection = matSupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matId != null ? matId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.matId == null && other.matId != null) || (this.matId != null && !this.matId.equals(other.matId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.Material[ matId=" + matId + " ]";
    }

    public Material(String name, String count) {
        this.name = name;
        this.count = count;
    }
    
}
