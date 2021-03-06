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
public class MatSupPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_id")
    private int matId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sup_id")
    private int supId;

    public MatSupPK() {
    }

    public MatSupPK(int matId, int supId) {
        this.matId = matId;
        this.supId = supId;
    }

    public int getMatId() {
        return matId;
    }

    public void setMatId(int matId) {
        this.matId = matId;
    }

    public int getSupId() {
        return supId;
    }

    public void setSupId(int supId) {
        this.supId = supId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) matId;
        hash += (int) supId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatSupPK)) {
            return false;
        }
        MatSupPK other = (MatSupPK) object;
        if (this.matId != other.matId) {
            return false;
        }
        if (this.supId != other.supId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.MatSupPK[ matId=" + matId + ", supId=" + supId + " ]";
    }
    
}
