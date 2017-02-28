/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pauva
 */
@Entity
@Table(name = "userdata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userdata.findAll", query = "SELECT u FROM Userdata u"),
    @NamedQuery(name = "Userdata.findByUserdataId", query = "SELECT u FROM Userdata u WHERE u.userdataId = :userdataId"),
    @NamedQuery(name = "Userdata.findByUserdataUserid", query = "SELECT u FROM Userdata u WHERE u.userdataUserid = :userdataUserid"),
    @NamedQuery(name = "Userdata.findByUserdataFirstname", query = "SELECT u FROM Userdata u WHERE u.userdataFirstname = :userdataFirstname"),
    @NamedQuery(name = "Userdata.findByUserdataLastname", query = "SELECT u FROM Userdata u WHERE u.userdataLastname = :userdataLastname"),
    @NamedQuery(name = "Userdata.findByUserdataPhonenumber", query = "SELECT u FROM Userdata u WHERE u.userdataPhonenumber = :userdataPhonenumber")})
public class Userdata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userdata_id")
    private Integer userdataId;
    @Size(max = 255)
    @Column(name = "userdata_userid")
    private String userdataUserid;
    @Size(max = 255)
    @Column(name = "userdata_firstname")
    private String userdataFirstname;
    @Size(max = 255)
    @Column(name = "userdata_lastname")
    private String userdataLastname;
    @Column(name = "userdata_phonenumber")
    private Integer userdataPhonenumber;

    public Userdata() {
    }

    public Userdata(Integer userdataId) {
        this.userdataId = userdataId;
    }

    public Integer getUserdataId() {
        return userdataId;
    }

    public void setUserdataId(Integer userdataId) {
        this.userdataId = userdataId;
    }

    public String getUserdataUserid() {
        return userdataUserid;
    }

    public void setUserdataUserid(String userdataUserid) {
        this.userdataUserid = userdataUserid;
    }

    public String getUserdataFirstname() {
        return userdataFirstname;
    }

    public void setUserdataFirstname(String userdataFirstname) {
        this.userdataFirstname = userdataFirstname;
    }

    public String getUserdataLastname() {
        return userdataLastname;
    }

    public void setUserdataLastname(String userdataLastname) {
        this.userdataLastname = userdataLastname;
    }

    public Integer getUserdataPhonenumber() {
        return userdataPhonenumber;
    }

    public void setUserdataPhonenumber(Integer userdataPhonenumber) {
        this.userdataPhonenumber = userdataPhonenumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userdataId != null ? userdataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userdata)) {
            return false;
        }
        Userdata other = (Userdata) object;
        if ((this.userdataId == null && other.userdataId != null) || (this.userdataId != null && !this.userdataId.equals(other.userdataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Userdata[ userdataId=" + userdataId + " ]";
    }
    
}
