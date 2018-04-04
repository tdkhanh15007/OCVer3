/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySsbean;

import MyEntity.CusInvoice;
import MyEntity.CusOrder;
import MyEntity.Worker;
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
public class CusOrderFacade extends AbstractFacade<CusOrder> implements CusOrderFacadeLocal {

    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CusOrderFacade() {
        super(CusOrder.class);
    }

    @Override
    public int getCatererID(List<Object[]> a,String us) {
        List<Object[]> ls = null;
        int i =0;
        for (Object[] a1 : a) {
            Query q = em.createNativeQuery("SELECT r.caterer_us,r.cusorder_id FROM CusOrder r WHERE r.cusorder_id = ?");
            q.setParameter(1, a1[0]);
            ls = q.getResultList();
            for (Object[] an : ls) {
                if(us.equals(an[0])){
                    i++;
                }
            }
        }
//        for (Object[] a1 : a) {
//
//            Query q = em.createNativeQuery("SELECT r.caterer_us FROM CusOrder r WHERE r.cusorder_id = :id");
//            q.setParameter("id", a1);
//            Object[] caterer_us = (Object[]) q.getSingleResult();
//            ls.add(caterer_us);
//        }
        return i;
    }
}
