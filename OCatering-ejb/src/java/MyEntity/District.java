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
@Table(name = "District")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d"),
    @NamedQuery(name = "District.findByDistrictId", query = "SELECT d FROM District d WHERE d.districtId = :districtId"),
    @NamedQuery(name = "District.findByDistname", query = "SELECT d FROM District d WHERE d.distname = :distname")})
public class District implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<Worker> workerCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Integer districtId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "distname")
    private String distname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<Customer> customerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<Caterer> catererCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<Supplier> supplierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<CusOrder> cusOrderCollection;

    public District() {
    }

    public District(Integer districtId) {
        this.districtId = districtId;
    }

    public District(Integer districtId, String distname) {
        this.districtId = districtId;
        this.distname = distname;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistname() {
        return distname;
    }

    public void setDistname(String distname) {
        this.distname = distname;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    public Collection<Caterer> getCatererCollection() {
        return catererCollection;
    }

    public void setCatererCollection(Collection<Caterer> catererCollection) {
        this.catererCollection = catererCollection;
    }

    @XmlTransient
    public Collection<Supplier> getSupplierCollection() {
        return supplierCollection;
    }

    public void setSupplierCollection(Collection<Supplier> supplierCollection) {
        this.supplierCollection = supplierCollection;
    }

    @XmlTransient
    public Collection<CusOrder> getCusOrderCollection() {
        return cusOrderCollection;
    }

    public void setCusOrderCollection(Collection<CusOrder> cusOrderCollection) {
        this.cusOrderCollection = cusOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtId != null ? districtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.districtId == null && other.districtId != null) || (this.districtId != null && !this.districtId.equals(other.districtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.District[ districtId=" + districtId + " ]";
    }

    public District(String distname) {
        this.distname = distname;
    }

    @XmlTransient
    public Collection<Worker> getWorkerCollection() {
        return workerCollection;
    }

    public void setWorkerCollection(Collection<Worker> workerCollection) {
        this.workerCollection = workerCollection;
    }
    
}
