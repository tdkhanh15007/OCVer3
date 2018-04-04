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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Khanh
 */
@Entity
@Table(name = "CusOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CusOrder.findAll", query = "SELECT c FROM CusOrder c"),
    @NamedQuery(name = "CusOrder.findByCusorderId", query = "SELECT c FROM CusOrder c WHERE c.cusorderId = :cusorderId"),
    @NamedQuery(name = "CusOrder.findByQuantity", query = "SELECT c FROM CusOrder c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "CusOrder.findByCostperplate", query = "SELECT c FROM CusOrder c WHERE c.costperplate = :costperplate"),
    @NamedQuery(name = "CusOrder.findByCreatedate", query = "SELECT c FROM CusOrder c WHERE c.createdate = :createdate"),
    @NamedQuery(name = "CusOrder.findByDeliverydate", query = "SELECT c FROM CusOrder c WHERE c.deliverydate = :deliverydate"),
    @NamedQuery(name = "CusOrder.findByDeliveryaddress", query = "SELECT c FROM CusOrder c WHERE c.deliveryaddress = :deliveryaddress"),
    @NamedQuery(name = "CusOrder.findByNote", query = "SELECT c FROM CusOrder c WHERE c.note = :note"),
    @NamedQuery(name = "CusOrder.findByStatus", query = "SELECT c FROM CusOrder c WHERE c.status = :status")})
public class CusOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cusorder_id")
    private Integer cusorderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costperplate")
    private Double costperplate;
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
    @Size(min = 1, max = 200)
    @Column(name = "deliveryaddress")
    private String deliveryaddress;
    @Size(max = 200)
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinTable(name = "OrderWorker", joinColumns = {
        @JoinColumn(name = "cusorder_id", referencedColumnName = "cusorder_id")}, inverseJoinColumns = {
        @JoinColumn(name = "worker_id", referencedColumnName = "worker_id")})
    @ManyToMany
    private Collection<Worker> workerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cusOrder")
    private Collection<CusOrderDetails> cusOrderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cusorderId")
    private Collection<CusInvoice> cusInvoiceCollection;
    @JoinColumn(name = "caterer_us", referencedColumnName = "caterer_us")
    @ManyToOne(optional = false)
    private Caterer catererUs;
    @JoinColumn(name = "cus_us", referencedColumnName = "cus_us")
    @ManyToOne(optional = false)
    private Customer cusUs;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private District districtId;

    public CusOrder() {
    }

    public CusOrder(Integer cusorderId) {
        this.cusorderId = cusorderId;
    }

    public CusOrder(Integer cusorderId, int quantity, Date createdate, Date deliverydate, String deliveryaddress, boolean status) {
        this.cusorderId = cusorderId;
        this.quantity = quantity;
        this.createdate = createdate;
        this.deliverydate = deliverydate;
        this.deliveryaddress = deliveryaddress;
        this.status = status;
    }

    public Integer getCusorderId() {
        return cusorderId;
    }

    public void setCusorderId(Integer cusorderId) {
        this.cusorderId = cusorderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getCostperplate() {
        return costperplate;
    }

    public void setCostperplate(Double costperplate) {
        this.costperplate = costperplate;
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

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Worker> getWorkerCollection() {
        return workerCollection;
    }

    public void setWorkerCollection(Collection<Worker> workerCollection) {
        this.workerCollection = workerCollection;
    }

    @XmlTransient
    public Collection<CusOrderDetails> getCusOrderDetailsCollection() {
        return cusOrderDetailsCollection;
    }

    public void setCusOrderDetailsCollection(Collection<CusOrderDetails> cusOrderDetailsCollection) {
        this.cusOrderDetailsCollection = cusOrderDetailsCollection;
    }

    @XmlTransient
    public Collection<CusInvoice> getCusInvoiceCollection() {
        return cusInvoiceCollection;
    }

    public void setCusInvoiceCollection(Collection<CusInvoice> cusInvoiceCollection) {
        this.cusInvoiceCollection = cusInvoiceCollection;
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

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusorderId != null ? cusorderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CusOrder)) {
            return false;
        }
        CusOrder other = (CusOrder) object;
        if ((this.cusorderId == null && other.cusorderId != null) || (this.cusorderId != null && !this.cusorderId.equals(other.cusorderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.CusOrder[ cusorderId=" + cusorderId + " ]";
    }

    public CusOrder(int quantity, Double costperplate, Date createdate, Date deliverydate, String deliveryaddress, String note, boolean status, Caterer catererUs, Customer cusUs, District districtId) {
        this.quantity = quantity;
        this.costperplate = costperplate;
        this.createdate = createdate;
        this.deliverydate = deliverydate;
        this.deliveryaddress = deliveryaddress;
        this.note = note;
        this.status = status;
        this.catererUs = catererUs;
        this.cusUs = cusUs;
        this.districtId = districtId;
    }
    
}
