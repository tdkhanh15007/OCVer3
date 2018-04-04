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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "Caterer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caterer.findAll", query = "SELECT c FROM Caterer c"),
    @NamedQuery(name = "Caterer.findByCatererUs", query = "SELECT c FROM Caterer c WHERE c.catererUs = :catererUs"),
    @NamedQuery(name = "Caterer.findByPassword", query = "SELECT c FROM Caterer c WHERE c.password = :password"),
    @NamedQuery(name = "Caterer.findByAddress", query = "SELECT c FROM Caterer c WHERE c.address = :address"),
    @NamedQuery(name = "Caterer.findByStatus", query = "SELECT c FROM Caterer c WHERE c.status = :status"),
    @NamedQuery(name = "Caterer.findByPhone", query = "SELECT c FROM Caterer c WHERE c.phone = :phone"),
    @NamedQuery(name = "Caterer.findByCatererName", query = "SELECT c FROM Caterer c WHERE c.catererName = :catererName")})
public class Caterer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "caterer_us")
    private String catererUs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "caterer_name")
    private String catererName;
    @JoinTable(name = "CatererFood", joinColumns = {
        @JoinColumn(name = "caterer_us", referencedColumnName = "caterer_us")}, inverseJoinColumns = {
        @JoinColumn(name = "food_id", referencedColumnName = "food_id")})
    @ManyToMany
    private Collection<Foods> foodsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catererUs")
    private Collection<FavList> favListCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catererUs")
    private Collection<Message> messageCollection;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private District districtId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catererUs")
    private Collection<SuppOrder> suppOrderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catererUs")
    private Collection<CusOrder> cusOrderCollection;

    public Caterer() {
    }

    public Caterer(String catererUs) {
        this.catererUs = catererUs;
    }

    public Caterer(String catererUs, String password, String address, boolean status, String phone, String catererName) {
        this.catererUs = catererUs;
        this.password = password;
        this.address = address;
        this.status = status;
        this.phone = phone;
        this.catererName = catererName;
    }

    public String getCatererUs() {
        return catererUs;
    }

    public void setCatererUs(String catererUs) {
        this.catererUs = catererUs;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCatererName() {
        return catererName;
    }

    public void setCatererName(String catererName) {
        this.catererName = catererName;
    }

    @XmlTransient
    public Collection<Foods> getFoodsCollection() {
        return foodsCollection;
    }

    public void setFoodsCollection(Collection<Foods> foodsCollection) {
        this.foodsCollection = foodsCollection;
    }

    @XmlTransient
    public Collection<FavList> getFavListCollection() {
        return favListCollection;
    }

    public void setFavListCollection(Collection<FavList> favListCollection) {
        this.favListCollection = favListCollection;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
    }

    @XmlTransient
    public Collection<SuppOrder> getSuppOrderCollection() {
        return suppOrderCollection;
    }

    public void setSuppOrderCollection(Collection<SuppOrder> suppOrderCollection) {
        this.suppOrderCollection = suppOrderCollection;
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
        hash += (catererUs != null ? catererUs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caterer)) {
            return false;
        }
        Caterer other = (Caterer) object;
        if ((this.catererUs == null && other.catererUs != null) || (this.catererUs != null && !this.catererUs.equals(other.catererUs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.Caterer[ catererUs=" + catererUs + " ]";
    }

    public Caterer(String catererUs, String password, String address, boolean status, String phone, String catererName, District districtId) {
        this.catererUs = catererUs;
        this.password = password;
        this.address = address;
        this.status = status;
        this.phone = phone;
        this.catererName = catererName;
        this.districtId = districtId;
    }
    
    
}
