/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesS;

import Entidades.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pauva
 */
@Stateless
public class QuestionsFacade extends AbstractFacade<Questions> {

    @PersistenceContext(unitName = "AccesoFinalPauVallsMoreno-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionsFacade() {
        super(Questions.class);
    }


    public List<Questions> findAllwOptions(Integer idtype) {
        Types type = em.find(Types.class, idtype);
        Query query = em.createQuery("SELECT DISTINCT q FROM Questions q JOIN FETCH q.optionsList WHERE q.questionsIdType=:type")
                .setParameter("type", type);
        return (List<Questions>) query.getResultList();
    }

    public List<Questions> findAllText() {
        Types type = em.find(Types.class, 1);
        Query query = em.createQuery("SELECT DISTINCT q FROM Questions q WHERE q.questionsIdType=:type")
                .setParameter("type", type);
        return (List<Questions>) query.getResultList();
    }
}
