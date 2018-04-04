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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Khanh
 */
@Entity
@Table(name = "Worker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Worker.findAll", query = "SELECT w FROM Worker w"),
    @NamedQuery(name = "Worker.findByWorkerId", query = "SELECT w FROM Worker w WHERE w.workerId = :workerId"),
    @NamedQuery(name = "Worker.findByName", query = "SELECT w FROM Worker w WHERE w.name = :name"),
    @NamedQuery(name = "Worker.findByAddress", query = "SELECT w FROM Worker w WHERE w.address = :address"),
    @NamedQuery(name = "Worker.findByPhone", query = "SELECT w FROM Worker w WHERE w.phone = :phone"),
    @NamedQuery(name = "Worker.findByDatejoin", query = "SELECT w FROM Worker w WHERE w.datejoin = :datejoin"),
    @NamedQuery(name = "Worker.findByStatus", query = "SELECT w FROM Worker w WHERE w.status = :status")})
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private Integer workerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
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
    @Column(name = "datejoin")
    @Temporal(TemporalType.DATE)
    private Date datejoin;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private District districtId;
    @JoinColumn(name = "worktype_id", referencedColumnName = "worktype_id")
    @ManyToOne(optional = false)
    private WorkerType worktypeId;

    public Worker() {
    }

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
    }

    public WorkerType getWorktypeId() {
        return worktypeId;
    }

    public void setWorktypeId(WorkerType worktypeId) {
        this.worktypeId = worktypeId;
    }  
    
    public Worker(Integer workerId) {
        this.workerId = workerId;
    }

    public Worker(Integer workerId, String name, String phone, Date datejoin) {
        this.workerId = workerId;
        this.name = name;
        this.phone = phone;
        this.datejoin = datejoin;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
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

    public Date getDatejoin() {
        return datejoin;
    }

    public void setDatejoin(Date datejoin) {
        this.datejoin = datejoin;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workerId != null ? workerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Worker)) {
            return false;
        }
        Worker other = (Worker) object;
        if ((this.workerId == null && other.workerId != null) || (this.workerId != null && !this.workerId.equals(other.workerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.Worker[ workerId=" + workerId + " ]";
    }

    public Worker(String name, String address, String phone, Date datejoin, Boolean status, District districtId, WorkerType worktypeId) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.datejoin = datejoin;
        this.status = status;
        this.districtId = districtId;
        this.worktypeId = worktypeId;
    }
    
}
