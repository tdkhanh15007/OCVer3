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
@Table(name = "WorkerType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkerType.findAll", query = "SELECT w FROM WorkerType w"),
    @NamedQuery(name = "WorkerType.findByWorktypeId", query = "SELECT w FROM WorkerType w WHERE w.worktypeId = :worktypeId"),
    @NamedQuery(name = "WorkerType.findByType", query = "SELECT w FROM WorkerType w WHERE w.type = :type"),
    @NamedQuery(name = "WorkerType.findByPayperday", query = "SELECT w FROM WorkerType w WHERE w.payperday = :payperday")})
public class WorkerType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worktype_id")
    private Integer worktypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payperday")
    private double payperday;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "worktypeId")
    private Collection<Worker> workerCollection;

    public WorkerType() {
    }

    public WorkerType(Integer worktypeId) {
        this.worktypeId = worktypeId;
    }

    public WorkerType(Integer worktypeId, String type, double payperday) {
        this.worktypeId = worktypeId;
        this.type = type;
        this.payperday = payperday;
    }

    public Integer getWorktypeId() {
        return worktypeId;
    }

    public void setWorktypeId(Integer worktypeId) {
        this.worktypeId = worktypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPayperday() {
        return payperday;
    }

    public void setPayperday(double payperday) {
        this.payperday = payperday;
    }

    @XmlTransient
    public Collection<Worker> getWorkerCollection() {
        return workerCollection;
    }

    public void setWorkerCollection(Collection<Worker> workerCollection) {
        this.workerCollection = workerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (worktypeId != null ? worktypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkerType)) {
            return false;
        }
        WorkerType other = (WorkerType) object;
        if ((this.worktypeId == null && other.worktypeId != null) || (this.worktypeId != null && !this.worktypeId.equals(other.worktypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.WorkerType[ worktypeId=" + worktypeId + " ]";
    }

    public WorkerType(String type, double payperday) {
        this.type = type;
        this.payperday = payperday;
    }
    
}
