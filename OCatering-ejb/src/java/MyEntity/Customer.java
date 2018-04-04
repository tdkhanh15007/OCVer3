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
@Table(name = "Customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCusUs", query = "SELECT c FROM Customer c WHERE c.cusUs = :cusUs"),
    @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name"),
    @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address"),
    @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByStatus", query = "SELECT c FROM Customer c WHERE c.status = :status"),
    @NamedQuery(name = "Customer.findByCusEmail", query = "SELECT c FROM Customer c WHERE c.cusEmail = :cusEmail")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cus_us")
    private String cusUs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cus_email")
    private String cusEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cusUs")
    private Collection<FavList> favListCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cusUs")
    private Collection<Message> messageCollection;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private District districtId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cusUs")
    private Collection<CusOrder> cusOrderCollection;

    public Customer() {
    }

    public Customer(String cusUs) {
        this.cusUs = cusUs;
    }

    public Customer(String cusUs, String name, String address, String phone, String password, boolean status, String cusEmail) {
        this.cusUs = cusUs;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.status = status;
        this.cusEmail = cusEmail;
    }

    public String getCusUs() {
        return cusUs;
    }

    public void setCusUs(String cusUs) {
        this.cusUs = cusUs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
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
    public Collection<CusOrder> getCusOrderCollection() {
        return cusOrderCollection;
    }

    public void setCusOrderCollection(Collection<CusOrder> cusOrderCollection) {
        this.cusOrderCollection = cusOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusUs != null ? cusUs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.cusUs == null && other.cusUs != null) || (this.cusUs != null && !this.cusUs.equals(other.cusUs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.Customer[ cusUs=" + cusUs + " ]";
    }
    
}
