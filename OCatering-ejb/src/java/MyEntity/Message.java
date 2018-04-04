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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Khanh
 */
@Entity
@Table(name = "Message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByMessId", query = "SELECT m FROM Message m WHERE m.messId = :messId"),
    @NamedQuery(name = "Message.findByMess", query = "SELECT m FROM Message m WHERE m.mess = :mess")})
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mess_id")
    private Integer messId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "mess")
    private String mess;
    @JoinColumn(name = "caterer_us", referencedColumnName = "caterer_us")
    @ManyToOne(optional = false)
    private Caterer catererUs;
    @JoinColumn(name = "cus_us", referencedColumnName = "cus_us")
    @ManyToOne(optional = false)
    private Customer cusUs;

    public Message() {
    }

    public Message(Integer messId) {
        this.messId = messId;
    }

    public Message(Integer messId, String mess) {
        this.messId = messId;
        this.mess = mess;
    }

    public Integer getMessId() {
        return messId;
    }

    public void setMessId(Integer messId) {
        this.messId = messId;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
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
        hash += (messId != null ? messId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messId == null && other.messId != null) || (this.messId != null && !this.messId.equals(other.messId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.Message[ messId=" + messId + " ]";
    }

    public Message(String mess, Caterer catererUs, Customer cusUs) {
        this.mess = mess;
        this.catererUs = catererUs;
        this.cusUs = cusUs;
    }
    
}
