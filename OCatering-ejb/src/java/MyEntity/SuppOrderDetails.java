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
@Table(name = "SuppOrderDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuppOrderDetails.findAll", query = "SELECT s FROM SuppOrderDetails s"),
    @NamedQuery(name = "SuppOrderDetails.findBySuporderId", query = "SELECT s FROM SuppOrderDetails s WHERE s.suppOrderDetailsPK.suporderId = :suporderId"),
    @NamedQuery(name = "SuppOrderDetails.findByMatId", query = "SELECT s FROM SuppOrderDetails s WHERE s.suppOrderDetailsPK.matId = :matId"),
    @NamedQuery(name = "SuppOrderDetails.findByQuantity", query = "SELECT s FROM SuppOrderDetails s WHERE s.quantity = :quantity")})
public class SuppOrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SuppOrderDetailsPK suppOrderDetailsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "mat_id", referencedColumnName = "mat_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Material material;
    @JoinColumn(name = "suporder_id", referencedColumnName = "suporder_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SuppOrder suppOrder;

    public SuppOrderDetails() {
    }

    public SuppOrderDetails(SuppOrderDetailsPK suppOrderDetailsPK) {
        this.suppOrderDetailsPK = suppOrderDetailsPK;
    }

    public SuppOrderDetails(SuppOrderDetailsPK suppOrderDetailsPK, int quantity) {
        this.suppOrderDetailsPK = suppOrderDetailsPK;
        this.quantity = quantity;
    }

    public SuppOrderDetails(int suporderId, int matId) {
        this.suppOrderDetailsPK = new SuppOrderDetailsPK(suporderId, matId);
    }

    public SuppOrderDetailsPK getSuppOrderDetailsPK() {
        return suppOrderDetailsPK;
    }

    public void setSuppOrderDetailsPK(SuppOrderDetailsPK suppOrderDetailsPK) {
        this.suppOrderDetailsPK = suppOrderDetailsPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public SuppOrder getSuppOrder() {
        return suppOrder;
    }

    public void setSuppOrder(SuppOrder suppOrder) {
        this.suppOrder = suppOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suppOrderDetailsPK != null ? suppOrderDetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuppOrderDetails)) {
            return false;
        }
        SuppOrderDetails other = (SuppOrderDetails) object;
        if ((this.suppOrderDetailsPK == null && other.suppOrderDetailsPK != null) || (this.suppOrderDetailsPK != null && !this.suppOrderDetailsPK.equals(other.suppOrderDetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.SuppOrderDetails[ suppOrderDetailsPK=" + suppOrderDetailsPK + " ]";
    }
    
}
