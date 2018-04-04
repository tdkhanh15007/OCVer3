/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyEntity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Khanh
 */
@Entity
@Table(name = "CusInvoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CusInvoice.findAll", query = "SELECT c FROM CusInvoice c"),
    @NamedQuery(name = "CusInvoice.findByCusinvoiceId", query = "SELECT c FROM CusInvoice c WHERE c.cusinvoiceId = :cusinvoiceId"),
    @NamedQuery(name = "CusInvoice.findByInvoicedate", query = "SELECT c FROM CusInvoice c WHERE c.invoicedate = :invoicedate"),
    @NamedQuery(name = "CusInvoice.findByDiscount", query = "SELECT c FROM CusInvoice c WHERE c.discount = :discount"),
    @NamedQuery(name = "CusInvoice.findByPrice", query = "SELECT c FROM CusInvoice c WHERE c.price = :price"),
    @NamedQuery(name = "CusInvoice.findByPrepaid", query = "SELECT c FROM CusInvoice c WHERE c.prepaid = :prepaid"),
    @NamedQuery(name = "CusInvoice.findByCreatedate", query = "SELECT c FROM CusInvoice c WHERE c.createdate = :createdate")})
public class CusInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cusinvoice_id")
    private Integer cusinvoiceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoicedate")
    @Temporal(TemporalType.DATE)
    private Date invoicedate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private int discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prepaid")
    private double prepaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdate")
    @Temporal(TemporalType.DATE)
    private Date createdate;
    @JoinColumn(name = "cusorder_id", referencedColumnName = "cusorder_id")
    @ManyToOne(optional = false)
    private CusOrder cusorderId;

    public CusInvoice() {
    }

    public CusInvoice(Integer cusinvoiceId) {
        this.cusinvoiceId = cusinvoiceId;
    }

    public CusInvoice(Integer cusinvoiceId, Date invoicedate, int discount, double price, double prepaid, Date createdate) {
        this.cusinvoiceId = cusinvoiceId;
        this.invoicedate = invoicedate;
        this.discount = discount;
        this.price = price;
        this.prepaid = prepaid;
        this.createdate = createdate;
    }

    public Integer getCusinvoiceId() {
        return cusinvoiceId;
    }

    public void setCusinvoiceId(Integer cusinvoiceId) {
        this.cusinvoiceId = cusinvoiceId;
    }

    public Date getInvoicedate() {
        return invoicedate;
    }

    public void setInvoicedate(Date invoicedate) {
        this.invoicedate = invoicedate;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(double prepaid) {
        this.prepaid = prepaid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public CusOrder getCusorderId() {
        return cusorderId;
    }

    public void setCusorderId(CusOrder cusorderId) {
        this.cusorderId = cusorderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusinvoiceId != null ? cusinvoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CusInvoice)) {
            return false;
        }
        CusInvoice other = (CusInvoice) object;
        if ((this.cusinvoiceId == null && other.cusinvoiceId != null) || (this.cusinvoiceId != null && !this.cusinvoiceId.equals(other.cusinvoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.CusInvoice[ cusinvoiceId=" + cusinvoiceId + " ]";
    }

    public CusInvoice(Date invoicedate, int discount, double price, double prepaid, Date createdate, CusOrder cusorderId) {
        this.invoicedate = invoicedate;
        this.discount = discount;
        this.price = price;
        this.prepaid = prepaid;
        this.createdate = createdate;
        this.cusorderId = cusorderId;
    }
    
}
