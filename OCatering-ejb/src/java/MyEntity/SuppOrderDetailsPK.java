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
public class SuppOrderDetailsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "suporder_id")
    private int suporderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_id")
    private int matId;

    public SuppOrderDetailsPK() {
    }

    public SuppOrderDetailsPK(int suporderId, int matId) {
        this.suporderId = suporderId;
        this.matId = matId;
    }

    public int getSuporderId() {
        return suporderId;
    }

    public void setSuporderId(int suporderId) {
        this.suporderId = suporderId;
    }

    public int getMatId() {
        return matId;
    }

    public void setMatId(int matId) {
        this.matId = matId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) suporderId;
        hash += (int) matId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuppOrderDetailsPK)) {
            return false;
        }
        SuppOrderDetailsPK other = (SuppOrderDetailsPK) object;
        if (this.suporderId != other.suporderId) {
            return false;
        }
        if (this.matId != other.matId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.SuppOrderDetailsPK[ suporderId=" + suporderId + ", matId=" + matId + " ]";
    }
    
}
