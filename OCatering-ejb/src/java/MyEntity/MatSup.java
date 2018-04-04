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
@Table(name = "MatSup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MatSup.findAll", query = "SELECT m FROM MatSup m"),
    @NamedQuery(name = "MatSup.findByMatId", query = "SELECT m FROM MatSup m WHERE m.matSupPK.matId = :matId"),
    @NamedQuery(name = "MatSup.findBySupId", query = "SELECT m FROM MatSup m WHERE m.matSupPK.supId = :supId"),
    @NamedQuery(name = "MatSup.findByRateperkg", query = "SELECT m FROM MatSup m WHERE m.rateperkg = :rateperkg")})
public class MatSup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatSupPK matSupPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rateperkg")
    private double rateperkg;
    @JoinColumn(name = "mat_id", referencedColumnName = "mat_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Material material;
    @JoinColumn(name = "sup_id", referencedColumnName = "sup_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Supplier supplier;

    public MatSup() {
    }

    public MatSup(MatSupPK matSupPK) {
        this.matSupPK = matSupPK;
    }

    public MatSup(MatSupPK matSupPK, double rateperkg) {
        this.matSupPK = matSupPK;
        this.rateperkg = rateperkg;
    }

    public MatSup(int matId, int supId) {
        this.matSupPK = new MatSupPK(matId, supId);
    }

    public MatSupPK getMatSupPK() {
        return matSupPK;
    }

    public void setMatSupPK(MatSupPK matSupPK) {
        this.matSupPK = matSupPK;
    }

    public double getRateperkg() {
        return rateperkg;
    }

    public void setRateperkg(double rateperkg) {
        this.rateperkg = rateperkg;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matSupPK != null ? matSupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatSup)) {
            return false;
        }
        MatSup other = (MatSup) object;
        if ((this.matSupPK == null && other.matSupPK != null) || (this.matSupPK != null && !this.matSupPK.equals(other.matSupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.MatSup[ matSupPK=" + matSupPK + " ]";
    }
    
}
