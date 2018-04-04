/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.MatSup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Khanh
 */
@Stateless
public class MatSupFacade extends AbstractFacade<MatSup> implements MatSupFacadeLocal {
    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatSupFacade() {
        super(MatSup.class);
    }
    
}
