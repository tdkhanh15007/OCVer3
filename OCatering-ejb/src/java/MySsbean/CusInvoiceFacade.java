/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySsbean;

import MyEntity.CusInvoice;
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
public class CusInvoiceFacade extends AbstractFacade<CusInvoice> implements CusInvoiceFacadeLocal {

    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CusInvoiceFacade() {
        super(CusInvoice.class);
    }

    @Override
    public List<Object[]> getOrderID() {
        Query q = em.createNativeQuery("SELECT a.cusorder_id,a.cusinvoice_id FROM CusInvoice a");
        List<Object[]> list1 = q.getResultList();
        return list1;
    }

}
