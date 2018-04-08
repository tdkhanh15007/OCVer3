/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySsbean;

import MyEntity.FoodMat;
import MyEntity.FoodMatPK;
import MyEntity.FoodMat_;
import MyEntity.Foods;
import MyEntity.Material;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Khanh
 */
@Stateless
public class FoodMatFacade extends AbstractFacade<FoodMat> implements FoodMatFacadeLocal {

    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FoodMatFacade() {
        super(FoodMat.class);
    }

    @Override
    public FoodMat returnFM(Material matID,Foods foodID) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery();
        Root root = query.from(FoodMat.class);
        query.where(builder.equal(root.get(FoodMat_.foods), foodID),builder.equal(root.get(FoodMat_.material), matID));
        Query q = em.createQuery(query);
        return (FoodMat) q.getSingleResult();
    }

}
