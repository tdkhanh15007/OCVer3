/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySsbean;

import MyEntity.FavList;
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
public class FavListFacade extends AbstractFacade<FavList> implements FavListFacadeLocal {

    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FavListFacade() {
        super(FavList.class);
    }

    @Override
    public int countFav(String us) {
        List<Object[]> ls = null;
        int i = 0;
        Query q = em.createNativeQuery("SELECT r.caterer_us,r.cus_us FROM FavList r WHERE r.caterer_us = ?");
        q.setParameter(1, us);
        ls = q.getResultList();
        for (Object[] an : ls) {
            i++;
        }
        return i;
    }

}
