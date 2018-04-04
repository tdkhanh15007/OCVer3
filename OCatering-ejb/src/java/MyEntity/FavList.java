/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyEntity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "FavList")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FavList.findAll", query = "SELECT f FROM FavList f"),
    @NamedQuery(name = "FavList.findByFavId", query = "SELECT f FROM FavList f WHERE f.favId = :favId")})
public class FavList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fav_id")
    private Integer favId;
    @JoinColumn(name = "caterer_us", referencedColumnName = "caterer_us")
    @ManyToOne(optional = false)
    private Caterer catererUs;
    @JoinColumn(name = "cus_us", referencedColumnName = "cus_us")
    @ManyToOne(optional = false)
    private Customer cusUs;

    public FavList() {
    }

    public FavList(Integer favId) {
        this.favId = favId;
    }

    public Integer getFavId() {
        return favId;
    }

    public void setFavId(Integer favId) {
        this.favId = favId;
    }

    public Caterer getCatererUs() {
        return catererUs;
    }

    public void setCatererUs(Caterer catererUs) {
        this.catererUs = catererUs;
    }

    public Customer getCusUs() {
        return cusUs;
    }

    public void setCusUs(Customer cusUs) {
        this.cusUs = cusUs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favId != null ? favId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavList)) {
            return false;
        }
        FavList other = (FavList) object;
        if ((this.favId == null && other.favId != null) || (this.favId != null && !this.favId.equals(other.favId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.FavList[ favId=" + favId + " ]";
    }

    public FavList(Caterer catererUs, Customer cusUs) {
        this.catererUs = catererUs;
        this.cusUs = cusUs;
    }
    
}
