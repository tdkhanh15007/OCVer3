/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySsbean;

import MyEntity.Foods;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Khanh
 */
@Stateless
public class FoodsFacade extends AbstractFacade<Foods> implements FoodsFacadeLocal {

    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FoodsFacade() {
        super(Foods.class);
    }

    @Override
    public List<Foods> listOldFood(String us) {
        List<Integer> ls = null;
        List<Foods> f1 = null;
        Query q = em.createNativeQuery("SELECT r.food_id FROM CatererFood r WHERE r.caterer_us = ?");
        q.setParameter(1, us);
        ls = q.getResultList();
        for (int i = 0; i < ls.size(); i++) {
            int foodid = ls.get(i);
            Query q1 = em.createQuery("SELECT w FROM Foods w where w.foodId != " + foodid);
            f1 = q1.getResultList();
        }
//        for (Integer a1 : ls) {
//            Query q1 = em.createNativeQuery("SELECT r FROM Foods r WHERE r.food_id != ?");
//            q1.setParameter(1, a1[0]);
//            f1 = q1.getResultList();
//        }
        return f1;
    }      
    
    @Override
    public int maxID(){
        Query q = em.createNativeQuery("SELECT r.food_id FROM Foods");
        return q.getMaxResults();
    }
}
