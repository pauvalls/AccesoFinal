/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesS;

import Entidades.Userquestions;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pauva
 */
@Stateless
public class UserquestionsFacade extends AbstractFacade<Userquestions> {

    @PersistenceContext(unitName = "AccesoFinalPauVallsMoreno-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserquestionsFacade() {
        super(Userquestions.class);
    }
    
}
