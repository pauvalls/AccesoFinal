/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import com.google.gson.annotations.SerializedName;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pauva
 */

@Entity
@Table(name = "useranswers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useranswers.findAll", query = "SELECT u FROM Useranswers u"),
    @NamedQuery(name = "Useranswers.findByUseranswersId", query = "SELECT u FROM Useranswers u WHERE u.useranswersId = :useranswersId"),
    @NamedQuery(name = "Useranswers.findByUserquestionsAnswer", query = "SELECT u FROM Useranswers u WHERE u.userquestionsAnswer = :userquestionsAnswer")})
public class Useranswers implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "useranswers_id")
    private Integer useranswersId;
    @Size(max = 255)
    @Column(name = "userquestions_answer")
    private String userquestionsAnswer;
    @JoinColumn(name = "useranswers_idquestion", referencedColumnName = "userquestions_id")
    @ManyToOne
    private Userquestions useranswersIdquestion;

    public Useranswers() {
    }

    public Useranswers(Integer useranswersId) {
        this.useranswersId = useranswersId;
    }

    public Integer getUseranswersId() {
        return useranswersId;
    }

    public void setUseranswersId(Integer useranswersId) {
        this.useranswersId = useranswersId;
    }

    public String getUserquestionsAnswer() {
        return userquestionsAnswer;
    }

    public void setUserquestionsAnswer(String userquestionsAnswer) {
        this.userquestionsAnswer = userquestionsAnswer;
    }

    public Userquestions getUseranswersIdquestion() {
        return useranswersIdquestion;
    }

    public void setUseranswersIdquestion(Userquestions useranswersIdquestion) {
        this.useranswersIdquestion = useranswersIdquestion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (useranswersId != null ? useranswersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useranswers)) {
            return false;
        }
        Useranswers other = (Useranswers) object;
        if ((this.useranswersId == null && other.useranswersId != null) || (this.useranswersId != null && !this.useranswersId.equals(other.useranswersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Useranswers[ useranswersId=" + useranswersId + " ]";
    }
    
}
