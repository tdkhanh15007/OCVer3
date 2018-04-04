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
import javax.persistence.Id;
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
@Table(name = "Admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByAdminUs", query = "SELECT a FROM Admin a WHERE a.adminUs = :adminUs"),
    @NamedQuery(name = "Admin.findByAdminEmail", query = "SELECT a FROM Admin a WHERE a.adminEmail = :adminEmail"),
    @NamedQuery(name = "Admin.findByPassword", query = "SELECT a FROM Admin a WHERE a.password = :password"),
    @NamedQuery(name = "Admin.findByStatus", query = "SELECT a FROM Admin a WHERE a.status = :status")})
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "admin_us")
    private String adminUs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "admin_email")
    private String adminEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;

    public Admin() {
    }

    public Admin(String adminUs) {
        this.adminUs = adminUs;
    }

    public Admin(String adminUs, String adminEmail, String password, boolean status) {
        this.adminUs = adminUs;
        this.adminEmail = adminEmail;
        this.password = password;
        this.status = status;
    }

    public String getAdminUs() {
        return adminUs;
    }

    public void setAdminUs(String adminUs) {
        this.adminUs = adminUs;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminUs != null ? adminUs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.adminUs == null && other.adminUs != null) || (this.adminUs != null && !this.adminUs.equals(other.adminUs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.Admin[ adminUs=" + adminUs + " ]";
    }
    
}
