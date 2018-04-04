/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySsbean;

import MyEntity.Worker;
import MyEntity.WorkerType;
import MyEntity.Worker_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

/**
 *
 * @author Khanh
 */
@Stateless
public class WorkerFacade extends AbstractFacade<Worker> implements WorkerFacadeLocal {

    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkerFacade() {
        super(Worker.class);
    }

//    @Override
//    public List<Worker> findType(WorkerType wt) {
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery query = builder.createQuery();
//        Root root = query.from(Worker.class);
//        query.select(root);
//        query.where(builder.equal(root.get(Worker_.worktypeId), wt));
//        Query q = em.createQuery(query);
//        return q.getResultList();
//    }
    @Override
    public List<Worker> findAllWorker() {
//        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
//        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();        
//        Root c = cq.from(Worker.class);
//        cq.select(c);
//        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(c.get("name")));
//        Query q = getEntityManager().createQuery(cq);
        Query query = em.createQuery("SELECT r FROM Worker r where r.status='"+true+"' order by r.worktypeId,r.name");
        return query.getResultList();
    }

}
