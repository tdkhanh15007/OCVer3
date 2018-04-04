/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySsbean;

import MyEntity.FoodMat;
import MyEntity.Material;
import java.util.ArrayList;
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
public class MaterialFacade extends AbstractFacade<Material> implements MaterialFacadeLocal {
    
    @PersistenceContext(unitName = "OCatering-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public MaterialFacade() {
        super(Material.class);
    }
    
    @Override
    public List<Material> listMat(int foodID) {
        List<Integer> ls = null;
        List<Material> f1 = null;
        Query q = em.createNativeQuery("SELECT r.mat_id FROM FoodMat r WHERE r.food_id = ?");
        q.setParameter(1, foodID);
        ls = q.getResultList();
        for (int i = 0; i < ls.size(); i++) {
            int matid = ls.get(i);
            Query q1 = em.createQuery("SELECT w FROM Material w where w.matId != " + matid);
            f1 = q1.getResultList();
        }
        return f1;
    }
    
    @Override
    public List<Integer> listMatbyName(String name) {
        List<Integer> ls1 = null;
//        List<Integer> ls2 = null;
//        List<FoodMat> ls2 = null;
        Query q = em.createQuery("SELECT r.matId FROM Material r WHERE r.name like '%" + name + "%'");
        ls1 = q.getResultList();
//        for (Integer integer1 : ls1) {
//            Query q1 = em.createNativeQuery("SELECT w.mat_id FROM FoodMat w where  w.mat_id = " + integer1.intValue()+" and w.food_id = "+1);
////            System.out.println(integer1.intValue());
//            if(q1.getResultList().isEmpty()){
//                ls2.add(integer1.intValue());
//            }
//        }
//        ls = q.getResultList();
//        for (int i = 0; i < ls1.size(); i++) {
//            q1 = em.createQuery("SELECT f FROM FoodMat f where f.foodMatPK.matId = " + ls1.get(i));            
//            ls2 = q1.getResultList();
//        }
        return ls1;
    }
    
//    @Override
//    public List<Integer> listMatbyName1(String name, int foodID) {
//        List<Integer> ls1 = null;
////        List<Integer> ls2 = null;
//        List<Integer> ls2 = null;
//        List<Integer> ls3 = null;
//        Query q = em.createQuery("SELECT r.matId FROM Material r WHERE r.name like '%" + name + "%'");
//        ls1 = q.getResultList();
//        for (Integer integer1 : ls1) {
//            System.out.println("metqua "+integer1.intValue());
//            Query q1 = em.createNativeQuery("SELECT w.mat_id FROM FoodMat w where  w.mat_id = " + integer1.intValue() + " and w.food_id = " + 13+"and w.quantity = 0");
//            ls2 = q1.getResultList();  
//            System.out.println(ls2.get(0));
//            ls3.add(0, ls2.get(0));
////            System.out.println(ls2.get(0));
////            for (Integer integer2 : ls2) {
////                ls3.add(integer2.intValue());
////            }
//////            System.out.println(integer1.intValue());
////            if(q1.getResultList().isEmpty()){
////                ls2.add(integer1.intValue());
////            }
//        }
//        System.out.println(ls2);
////        for (Integer integer3 : ls3) {
////            System.out.println(integer3.intValue());
////        }
////        ls = q.getResultList();
////        for (int i = 0; i < ls1.size(); i++) {
////            q1 = em.createQuery("SELECT f FROM FoodMat f where f.foodMatPK.matId = " + ls1.get(i));            
////            ls2 = q1.getResultList();
////        }
//        return ls3;
//    }
    
}
