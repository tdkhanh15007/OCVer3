/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Khanh
 */
@Entity
@Table(name = "SuppOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuppOrder.findAll", query = "SELECT s FROM SuppOrder s"),
    @NamedQuery(name = "SuppOrder.findBySuporderId", query = "SELECT s FROM SuppOrder s WHERE s.suporderId = :suporderId"),
    @NamedQuery(name = "SuppOrder.findByCreatedate", query = "SELECT s FROM SuppOrder s WHERE s.createdate = :createdate"),
    @NamedQuery(name = "SuppOrder.findByDeliverydate", query = "SELECT s FROM SuppOrder s WHERE s.deliverydate = :deliverydate"),
    @NamedQuery(name = "SuppOrder.findByPrice", query = "SELECT s FROM SuppOrder s WHERE s.price = :price"),
    @NamedQuery(name = "SuppOrder.findByStatus", query = "SELECT s FROM SuppOrder s WHERE s.status = :status")})
public class SuppOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suporder_id")
    private Integer suporderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdate")
    @Temporal(TemporalType.DATE)
    private Date createdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deliverydate")
    @Temporal(TemporalType.DATE)
    private Date deliverydate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suppOrder")
    private Collection<SuppOrderDetails> suppOrderDetailsCollection;
    @JoinColumn(name = "caterer_us", referencedColumnName = "caterer_us")
    @ManyToOne(optional = false)
    private Caterer catererUs;
    @JoinColumn(name = "sup_id", referencedColumnName = "sup_id")
    @ManyToOne(optional = false)
    private Supplier supId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suporderId")
    private Collection<SuppInvoice> suppInvoiceCollection;

    public SuppOrder() {
    }

    public SuppOrder(Integer suporderId) {
        this.suporderId = suporderId;
    }

    public SuppOrder(Integer suporderId, Date createdate, Date deliverydate, double price, boolean status) {
        this.suporderId = suporderId;
        this.createdate = createdate;
        this.deliverydate = deliverydate;
        this.price = price;
        this.status = status;
    }

    public Integer getSuporderId() {
        return suporderId;
    }

    public void setSuporderId(Integer suporderId) {
        this.suporderId = suporderId;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<SuppOrderDetails> getSuppOrderDetailsCollection() {
        return suppOrderDetailsCollection;
    }

    public void setSuppOrderDetailsCollection(Collection<SuppOrderDetails> suppOrderDetailsCollection) {
        this.suppOrderDetailsCollection = suppOrderDetailsCollection;
    }

    public Caterer getCatererUs() {
        return catererUs;
    }

    public void setCatererUs(Caterer catererUs) {
        this.catererUs = catererUs;
    }

    public Supplier getSupId() {
        return supId;
    }

    public void setSupId(Supplier supId) {
        this.supId = supId;
    }

    @XmlTransient
    public Collection<SuppInvoice> getSuppInvoiceCollection() {
        return suppInvoiceCollection;
    }

    public void setSuppInvoiceCollection(Collection<SuppInvoice> suppInvoiceCollection) {
        this.suppInvoiceCollection = suppInvoiceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suporderId != null ? suporderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuppOrder)) {
            return false;
        }
        SuppOrder other = (SuppOrder) object;
        if ((this.suporderId == null && other.suporderId != null) || (this.suporderId != null && !this.suporderId.equals(other.suporderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.SuppOrder[ suporderId=" + suporderId + " ]";
    }

    public SuppOrder(Date createdate, Date deliverydate, double price, boolean status, Caterer catererUs, Supplier supId) {
        this.createdate = createdate;
        this.deliverydate = deliverydate;
        this.price = price;
        this.status = status;
        this.catererUs = catererUs;
        this.supId = supId;
    }
    
}
