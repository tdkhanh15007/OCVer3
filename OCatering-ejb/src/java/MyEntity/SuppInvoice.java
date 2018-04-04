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
@Table(name = "SuppInvoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuppInvoice.findAll", query = "SELECT s FROM SuppInvoice s"),
    @NamedQuery(name = "SuppInvoice.findBySuppinvoiceId", query = "SELECT s FROM SuppInvoice s WHERE s.suppinvoiceId = :suppinvoiceId"),
    @NamedQuery(name = "SuppInvoice.findByPaiddate", query = "SELECT s FROM SuppInvoice s WHERE s.paiddate = :paiddate"),
    @NamedQuery(name = "SuppInvoice.findByCreatedate", query = "SELECT s FROM SuppInvoice s WHERE s.createdate = :createdate"),
    @NamedQuery(name = "SuppInvoice.findByAmountpaid", query = "SELECT s FROM SuppInvoice s WHERE s.amountpaid = :amountpaid")})
public class SuppInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suppinvoice_id")
    private Integer suppinvoiceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paiddate")
    @Temporal(TemporalType.DATE)
    private Date paiddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdate")
    @Temporal(TemporalType.DATE)
    private Date createdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amountpaid")
    private double amountpaid;
    @JoinColumn(name = "suporder_id", referencedColumnName = "suporder_id")
    @ManyToOne(optional = false)
    private SuppOrder suporderId;

    public SuppInvoice() {
    }

    public SuppInvoice(Integer suppinvoiceId) {
        this.suppinvoiceId = suppinvoiceId;
    }

    public SuppInvoice(Integer suppinvoiceId, Date paiddate, Date createdate, double amountpaid) {
        this.suppinvoiceId = suppinvoiceId;
        this.paiddate = paiddate;
        this.createdate = createdate;
        this.amountpaid = amountpaid;
    }

    public Integer getSuppinvoiceId() {
        return suppinvoiceId;
    }

    public void setSuppinvoiceId(Integer suppinvoiceId) {
        this.suppinvoiceId = suppinvoiceId;
    }

    public Date getPaiddate() {
        return paiddate;
    }

    public void setPaiddate(Date paiddate) {
        this.paiddate = paiddate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public double getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(double amountpaid) {
        this.amountpaid = amountpaid;
    }

    public SuppOrder getSuporderId() {
        return suporderId;
    }

    public void setSuporderId(SuppOrder suporderId) {
        this.suporderId = suporderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suppinvoiceId != null ? suppinvoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuppInvoice)) {
            return false;
        }
        SuppInvoice other = (SuppInvoice) object;
        if ((this.suppinvoiceId == null && other.suppinvoiceId != null) || (this.suppinvoiceId != null && !this.suppinvoiceId.equals(other.suppinvoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.SuppInvoice[ suppinvoiceId=" + suppinvoiceId + " ]";
    }

    public SuppInvoice(Date paiddate, Date createdate, double amountpaid, SuppOrder suporderId) {
        this.paiddate = paiddate;
        this.createdate = createdate;
        this.amountpaid = amountpaid;
        this.suporderId = suporderId;
    }
    
}
