/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pauva
 */
@Entity
@Table(name = "userquestions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userquestions.findAll", query = "SELECT u FROM Userquestions u"),
    @NamedQuery(name = "Userquestions.findByUserquestionsId", query = "SELECT u FROM Userquestions u WHERE u.userquestionsId = :userquestionsId")})
public class Userquestions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userquestions_id")
    private Integer userquestionsId;
    @JoinColumn(name = "userquestions_idquestion", referencedColumnName = "questions_id")
    @ManyToOne
    private Questions userquestionsIdquestion;
    @JoinColumn(name = "userquestions_idexam", referencedColumnName = "userexams_id")
    @ManyToOne
    private Userexams userquestionsIdexam;
    @OneToMany(mappedBy = "useranswersIdquestion")
    private List<Useranswers> useranswersList;

    public Userquestions() {
    }

    public Userquestions(Questions userquestionsIdquestion, Userexams userquestionsIdexam) {
        this.userquestionsIdquestion = userquestionsIdquestion;
        this.userquestionsIdexam = userquestionsIdexam;
    }

    public Userquestions(Integer userquestionsId) {
        this.userquestionsId = userquestionsId;
    }

    public Integer getUserquestionsId() {
        return userquestionsId;
    }

    public void setUserquestionsId(Integer userquestionsId) {
        this.userquestionsId = userquestionsId;
    }

    public Questions getUserquestionsIdquestion() {
        return userquestionsIdquestion;
    }

    public void setUserquestionsIdquestion(Questions userquestionsIdquestion) {
        this.userquestionsIdquestion = userquestionsIdquestion;
    }

    public Userexams getUserquestionsIdexam() {
        return userquestionsIdexam;
    }

    public void setUserquestionsIdexam(Userexams userquestionsIdexam) {
        this.userquestionsIdexam = userquestionsIdexam;
    }

    @XmlTransient
    public List<Useranswers> getUseranswersList() {
        return useranswersList;
    }

    public void setUseranswersList(List<Useranswers> useranswersList) {
        this.useranswersList = useranswersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userquestionsId != null ? userquestionsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userquestions)) {
            return false;
        }
        Userquestions other = (Userquestions) object;
        if ((this.userquestionsId == null && other.userquestionsId != null) || (this.userquestionsId != null && !this.userquestionsId.equals(other.userquestionsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Userquestions[ userquestionsId=" + userquestionsId + " ]";
    }
    
}
