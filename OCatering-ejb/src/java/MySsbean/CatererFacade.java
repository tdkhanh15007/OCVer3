/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.Caterer;
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
public class CatererFacade extends AbstractFacade<Caterer> implements CatererFacadeLocal {
    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatererFacade() {
        super(Caterer.class);
    }
    
    @Override
    public List<Object[]> getCatererUS() {
        Query q = em.createNativeQuery("SELECT a.caterer_us,a.caterer_name FROM Caterer a");
        List<Object[]> list1 = q.getResultList();
        return list1;
    }
    
}
