/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pauva
 */
@Entity
@Table(name = "userexams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userexams.findAll", query = "SELECT u FROM Userexams u"),
    @NamedQuery(name = "Userexams.findByUserexamsId", query = "SELECT u FROM Userexams u WHERE u.userexamsId = :userexamsId"),
    @NamedQuery(name = "Userexams.findByUserexamsUserid", query = "SELECT u FROM Userexams u WHERE u.userexamsUserid = :userexamsUserid"),
    @NamedQuery(name = "Userexams.findByUserexamsStarttime", query = "SELECT u FROM Userexams u WHERE u.userexamsStarttime = :userexamsStarttime"),
    @NamedQuery(name = "Userexams.findByUserexamsEndtime", query = "SELECT u FROM Userexams u WHERE u.userexamsEndtime = :userexamsEndtime")})
public class Userexams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userexams_id")
    private Integer userexamsId;
    @Size(max = 255)
    @Column(name = "userexams_userid")
    private String userexamsUserid;
    @Column(name = "userexams_starttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userexamsStarttime;
    @Column(name = "userexams_endtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userexamsEndtime;
    @OneToMany(mappedBy = "userquestionsIdexam")
    private List<Userquestions> userquestionsList;

    public Userexams() {
    }

    public Userexams(Integer userexamsId) {
        this.userexamsId = userexamsId;
    }

    public Integer getUserexamsId() {
        return userexamsId;
    }

    public void setUserexamsId(Integer userexamsId) {
        this.userexamsId = userexamsId;
    }

    public String getUserexamsUserid() {
        return userexamsUserid;
    }

    public void setUserexamsUserid(String userexamsUserid) {
        this.userexamsUserid = userexamsUserid;
    }

    public Date getUserexamsStarttime() {
        return userexamsStarttime;
    }

    public void setUserexamsStarttime(Date userexamsStarttime) {
        this.userexamsStarttime = userexamsStarttime;
    }

    public Date getUserexamsEndtime() {
        return userexamsEndtime;
    }

    public void setUserexamsEndtime(Date userexamsEndtime) {
        this.userexamsEndtime = userexamsEndtime;
    }

    @XmlTransient
    public List<Userquestions> getUserquestionsList() {
        return userquestionsList;
    }

    public void setUserquestionsList(List<Userquestions> userquestionsList) {
        this.userquestionsList = userquestionsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userexamsId != null ? userexamsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userexams)) {
            return false;
        }
        Userexams other = (Userexams) object;
        if ((this.userexamsId == null && other.userexamsId != null) || (this.userexamsId != null && !this.userexamsId.equals(other.userexamsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Userexams[ userexamsId=" + userexamsId + " ]";
    }
    
}
